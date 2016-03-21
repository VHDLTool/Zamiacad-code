/* 
 * Copyright 2005-2011 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 * Created by guenter on Dec 30, 2005
 */
package org.zamia;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.zamia.cli.jython.ZCJInterpreter;
import org.zamia.instgraph.IGManager;
import org.zamia.rtl.RTLManager;
import org.zamia.tool.vhdl.ToolVhdlManager;
import org.zamia.util.ZHash;
import org.zamia.util.ZamiaTmpDir;
import org.zamia.verilog.VerilogParser;
import org.zamia.vhdl.VHDLIndexer;
import org.zamia.vhdl.vhdl2008.VHDL2008Parser;
import org.zamia.zdb.ZDB;
import org.zamia.zdb.ZDBException;

/**
 * The class ZamiaProject is the central point holding together all zamia
 * classes, objects and structures related to a project.
 * 
 * It takes care of IG and (todo) RTLGraph generation and persistence. Also
 * anchors the central compiler invocation and DU storage facility DUManager and
 * the build path.
 * 
 * @author Guenter Bartsch
 */

public class ZamiaProject {

	protected final static ZamiaLogger logger = ZamiaLogger.getInstance();

	protected final static ExceptionLogger el = ExceptionLogger.getInstance();

	private static final String ZCJ_CLEAN_CMD = "zamia_build_clean";

	private String fId;

	public final FileIterator fBasePath;
	
	private final String fDataPath;

	/**This is a directory of project files. It can be virtual if you override the class (useful for linking files in IDE). */
	public static class FileIterator { 
		private final String dir;
		public FileIterator (String aDataPath) {
			dir = aDataPath;
		}
		public File[] getFiles() throws IOException, ZamiaException {
			return new File(dir).listFiles();
		}
		
		/** Computes local path, relative to the base dir, and calls new SourceFile(absolute, local) 
		 * @throws IOException */
		public SourceFile toSF(File absoluteLocation) throws ZamiaException, IOException {
			String lp = new File(dir).toURI().relativize(absoluteLocation.toURI()).getPath();
			lp = lp.replace("/", File.separator);
			return new SourceFile(absoluteLocation, lp);
		}
		public String toString() { 
			return dir;
		}
	}
	
	private ZDB fZDB;

	private BuildPath fBuildPath;

	private IHDLParser fVHDLParser, fVerilogParser;

	private VHDLIndexer fVHDLIndexer;

	private ZamiaProjectBuilder fBuilder;

	private DMManager fDUM;

	private IGManager fIGM;

	// error manager
	private ERManager fERM;

	private RTLManager fRTLM;

	private ZCJInterpreter fZCJ;
	
	private ToolVhdlManager toolVhdlManager;

	private static final String BUILDPATH_OBJ_NAME = "ZPRJ_BuildPath";

	public ZamiaProject(String aId, String aBasePath, SourceFile aBuildPath, String aDataPath) throws IOException, ZamiaException, ZDBException {
		this(aId, new FileIterator(aBasePath), aBuildPath, aDataPath);
	}
	public ZamiaProject(String aId, FileIterator aBasePath, SourceFile aBuildPath, String aDataPath) throws IOException, ZamiaException, ZDBException {
		fId = aId;
		fBasePath = aBasePath;
		fDataPath = aDataPath != null ? aDataPath : ZamiaTmpDir.getTmpDir().getAbsolutePath();

		registerProject(this);

		File dbDir = new File(fDataPath + File.separator + "db" + File.separator + ZHash.encodeZ(fId));

		logger.info("ZamiaProject: project %s: Using db directory: %s", fId, dbDir.getAbsolutePath());

		fZDB = new ZDB(dbDir, this);

		fERM = new ERManager(this);
		
		toolVhdlManager = new ToolVhdlManager();
		
		fVHDLParser = new VHDL2008Parser();
		fVHDLIndexer = new VHDLIndexer();
		fVerilogParser = new VerilogParser();

		fBuildPath = (BuildPath) fZDB.getNamedObject(BUILDPATH_OBJ_NAME);
		if (fBuildPath == null) {
			setBuildPath(new BuildPath(aBuildPath));
		} else {
			SourceFile sf1 = fBuildPath.getSourceFile();
			if (sf1 == null && aBuildPath != null || sf1 != null && aBuildPath == null || sf1 != null && !sf1.equals(aBuildPath)) {
				setBuildPath(new BuildPath(aBuildPath));
			}
		}

		fDUM = new DMManager(this);

		fBuilder = new ZamiaProjectBuilder(this);

		fIGM = new IGManager(this);
		fRTLM = new RTLManager(this);

		initJythonInterpreter();
	}

	public void initJythonInterpreter() {
		try {
			fZCJ = new ZCJInterpreter(this);

			// run init script

			File initScript = new File(System.getProperty("user.home") + File.separator + ".zamia" + File.separator + "init.py");

			if (initScript.exists()) {
				logger.debug("Running init.py from %s", initScript.getAbsoluteFile());
				fZCJ.evalFile(initScript.getAbsolutePath());
			}

			// run project specific init scripts

			int n = fBuildPath.getNumScripts();
			for (int i = 0; i < n; i++) {
				String script = fBuildPath.getScript(i);
				fZCJ.evalFile(script);
			}

		} catch (Throwable e) {
			el.logException(e);
		}
	}

	public ZamiaProject(String aId, String aBasePath, SourceFile aBuildPath) throws IOException, ZamiaException, ZDBException {
		this(aId, aBasePath, aBuildPath, null);
	}

	public ZamiaProject() throws IOException, ZamiaException, ZDBException {
		this("unnamed project", ".", null);
	}

	public ZDB getZDB() {
		return fZDB;
	}

	public void clean() throws IOException, ZamiaException {
		logger.info("Cleaning project '%s'", fBasePath);
		ZamiaProfiler.getInstance().startTimer("Cleaning");
		fZDB.clear();
		setBuildPath(new BuildPath(fBuildPath.getSourceFile()));
		fDUM.clean();
		fERM.clean();
		fBuilder.clean();
		toolVhdlManager.clean();
		
		if (fZCJ.hasCommand(ZCJ_CLEAN_CMD)) {
			try {
				fZCJ.eval(ZCJ_CLEAN_CMD);
			} catch (Throwable e) {
				el.logException(e);
			}
		}

		initJythonInterpreter();

		ZamiaProfiler.getInstance().stopTimer("Cleaning");
	}

	public void zdbChanged() {
		setBuildPath(new BuildPath(fBuildPath.getSourceFile()));

		fDUM.zdbChanged();
		fERM.zdbChanged();
		fBuilder.zdbChanged();
	}

	public DMManager getDUM() {
		return fDUM;
	}

	public void shutdown() {
		fZDB.shutdown();
	}

	public ZamiaProjectBuilder getBuilder() {
		return fBuilder;
	}

	public String getId() {
		return fId;
	}

	public IGManager getIGM() {
		return fIGM;
	}

	public ERManager getERM() {
		return fERM;
	}

	public RTLManager getRTLM() {
		return fRTLM;
	}

	public ToolVhdlManager getToolVhdlMgr(){
		return toolVhdlManager;
	}
	
	public VHDLIndexer getVHDLIndexer() {
		return fVHDLIndexer;
	}

	public IHDLParser getVHDLParser() {
		return fVHDLParser;
	}

	public IHDLParser getVerilogParser() {
		return fVerilogParser;
	}

	@Override
	public String toString() {
		return "ZamiaProject " + fId;
	}

	public void setBuildPath(BuildPath aBP) {
		fZDB.createNamedObject(BUILDPATH_OBJ_NAME, aBP);
		fBuildPath = aBP;
	}

	public BuildPath getBuildPath() {
		return fBuildPath;
	}

	public String getDataPath() {
		return fDataPath;
	}
	
	public ZCJInterpreter getZCJ() {
		return fZCJ;
	}

	/*
	 * editor path storage
	 */

	public void storeEditorPath(String aFilename, String aPath) {

		fZDB.putIdxObj("EPIdx", aFilename, aPath);
	}

	public String lookupEditorPath(String aFilename) {

		long id = fZDB.getIdx("EPIdx", aFilename);
		if (id == 0)
			return null;

		return (String) fZDB.load(id);
	}

	/*
	 * 
	 * static project registry
	 * 
	 */

	private static HashMap<String, ZamiaProject> projectMap = new HashMap<String, ZamiaProject>();

	private static void registerProject(ZamiaProject aPrj) {
		projectMap.put(aPrj.getId(), aPrj);
	}

	public static ZamiaProject lookupProject(String aId) {
		return projectMap.get(aId);
	}

}
