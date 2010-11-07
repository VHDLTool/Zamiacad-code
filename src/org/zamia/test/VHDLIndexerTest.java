/* 
 * Copyright 2008,2009 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 * Created by Guenter Bartsch on Jan 5, 2008
 */
package org.zamia.test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import junit.framework.TestCase;

import org.apache.log4j.Level;
import org.zamia.BuildPath;
import org.zamia.BuildPathEntry;
import org.zamia.DMManager;
import org.zamia.FSCache;
import org.zamia.SourceFile;
import org.zamia.ZamiaException;
import org.zamia.ZamiaLogger;
import org.zamia.ZamiaProject;
import org.zamia.vhdl.VHDLIndexer;


/**
 * 
 * @author Guenter Bartsch
 *
 */
public class VHDLIndexerTest extends TestCase {

	private static FSCache fsCache = FSCache.getInstance();

	private int fNumFiles;

	private int fNumLines;

	private VHDLIndexer fIndexer;

	private ZamiaProject fZPrj;

	private DMManager fDUM;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ZamiaLogger.setup(Level.INFO);
		fIndexer = new VHDLIndexer();

		fZPrj = new ZamiaProject();
		fDUM = fZPrj.getDUM();

	}

	public void indexFile(SourceFile aSF) throws IOException, ZamiaException {

		String fileName = aSF.getFileName();
		if (!fileName.endsWith(".vhd") && !fileName.endsWith("vhdl"))
			return;

		Reader r = fsCache.openFile(aSF, false);
		try {
			fIndexer.parse(r, "dummy", aSF, 0, false, true, fDUM);
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public void indexDir(File aDir) throws IOException, ZamiaException {
		File[] files = aDir.listFiles();
		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			File f = files[i];

			if (f.isDirectory()) {
				indexDir(f);
			} else {

				SourceFile sf = new SourceFile(f);

				indexFile(sf);
				fNumFiles++;
				fNumLines += sf.getNumLines();
			}
		}
	}

	public void testIndexer() throws Exception {

		BuildPath bp = new BuildPath();
		bp.setSrc(new SourceFile(new File("test/BuildPath.txt")));
		bp.parse(null, false, null);

		fNumFiles = 0;
		fNumLines = 0;

		long startTime = System.currentTimeMillis();

		int n = bp.getNumEntries();
		for (int i = 0; i < n; i++) {
			BuildPathEntry entry = bp.getEntry(i);

			if (entry.fExtern) {
				System.out.println("*** indexing external source: " + entry.fPrefix);

				indexDir(new File(entry.fPrefix));
			}
		}

		long time = System.currentTimeMillis() - startTime;
		System.out.println("Runtime of leon indexing            : " + time + " msec");
		System.out.println("Number of files indexed             : " + fNumFiles);
		System.out.println("Number of lines of VHDL code indexed: " + fNumLines);

	}

	public static void main(String args[]) {
		VHDLIndexerTest t = new VHDLIndexerTest();
		try {
			t.setUp();
			t.testIndexer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
