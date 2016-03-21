package org.zamia.tool.vhdl;

import java.util.Observable;


public class ToolVhdlManager extends Observable {
	
	private BuildMakeE buildMake;

	public ToolVhdlManager() {
		buildMake = BuildMakeE.NO;
	}
	
	public BuildMakeE getBuildMake() {
		return buildMake;
	}

	public void setBuildMake(BuildMakeE _buildMake) {
		buildMake = _buildMake;
		if (buildMake == BuildMakeE.YES) {
			this.setChanged();
			this.notifyObservers();
		}
	}

	public void clean() {
		buildMake = BuildMakeE.NO;
	}

}
