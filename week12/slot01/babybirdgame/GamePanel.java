package week12.slot01.babybirdgame;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	FlightPanel flightPanel;
	
	public GamePanel() {
		flightPanel = new FlightPanel();
		this.add(flightPanel);
	}
	
}
