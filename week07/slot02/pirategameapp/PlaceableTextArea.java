package week07.slot02.pirategameapp;

import javax.swing.JTextArea;

public class PlaceableTextArea extends JTextArea {

	private int arenaXLoc;
	private int arenaYLoc;
	
	public PlaceableTextArea(int xLoc, int yLoc) {
		arenaXLoc = xLoc;
		arenaYLoc = yLoc;
	}

	public int getArenaXLoc() {
		return arenaXLoc;
	}

	public void setArenaXLoc(int arenaXLoc) {
		this.arenaXLoc = arenaXLoc;
	}

	public int getArenaYLoc() {
		return arenaYLoc;
	}

	public void setArenaYLoc(int arenaYLoc) {
		this.arenaYLoc = arenaYLoc;
	}
	
}
