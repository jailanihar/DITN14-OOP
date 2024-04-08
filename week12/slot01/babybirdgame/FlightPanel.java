package week12.slot01.babybirdgame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FlightPanel extends JPanel {

	final int WIDTH = 600, HEIGHT = 600;
	BirdPanel bird;
	Timer timer;
	boolean isWingUp = true;
	
	public FlightPanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.GREEN);
		
		bird = new BirdPanel();
		bird.setBounds(10, 
				HEIGHT / 2,
				bird.getPreferredSize().width,
				bird.getPreferredSize().height);
		
		timer = new Timer(30, e -> {
			bird.setBounds(
					10,
					bird.getBounds().y + 5,
					bird.getPreferredSize().width,
					bird.getPreferredSize().height
					);
			
			if(isWingUp) {
				bird.wingDown();
				isWingUp = false;
			} else {
				bird.wingUp();
				isWingUp = true;
			}
			repaint();
		});
		timer.start();
		
		this.add(bird);
	}
	
}
