package week13.slot01.babybirdgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BirdPanel extends JPanel {
	
	int[] beakX = {25, 35, 25};
	int[] beakY = {10, 15, 20};
	int[] wingX = {0, 15, 5};
	int[] wingY = {0, 10, 20};

	public BirdPanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(35, 25));
		this.setOpaque(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Beak
		g.drawPolygon(beakX, beakY, 3);
		g.setColor(Color.YELLOW);
		g.fillPolygon(beakX, beakY, 3);
		
		// Body
		g.setColor(Color.BLACK);
		g.drawOval(5, 5, 20, 20);
		g.setColor(Color.GRAY);
		g.fillOval(5, 5, 20, 20);
		
		// Eye
		g.setColor(Color.BLACK);
		g.drawOval(20, 10, 5, 5);
		g.fillOval(20, 10, 5, 5);
		
		// Wing
		g.drawPolygon(wingX, wingY, 3);
		g.setColor(Color.ORANGE);
		g.fillPolygon(wingX, wingY, 3);
	}
	
	public void wingUp() {
		wingX[0] = 0;
		wingY[0] = 0;
	}
	
	public void wingDown() {
		wingX[0] = 0;
		wingY[0] = 10;
	}
}
