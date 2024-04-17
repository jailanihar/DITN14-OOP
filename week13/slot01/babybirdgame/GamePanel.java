package week13.slot01.babybirdgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	static int prevScore = 0, score = 0;
	static ScorePanel prevScorePanel, scorePanel;
	FlightPanel flightPanel;
	boolean spacePressed = false;
	
	public GamePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		prevScorePanel = new ScorePanel("Previous Score: ", prevScore);
		this.add(prevScorePanel);
		
		scorePanel = new ScorePanel("Current Score: ", score);
		this.add(scorePanel);
		
		flightPanel = new FlightPanel();
		this.add(flightPanel);
		
		BabyBirdGame.frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(spacePressed == false) {				
				flightPanel.gameStart = true;
				flightPanel.bird.wingDown();
				flightPanel.bird.setBounds(
						10,
						flightPanel.bird.getBounds().y - 50,
						flightPanel.bird.getPreferredSize().width,
						flightPanel.bird.getPreferredSize().height);
				repaint();
			}
			spacePressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			flightPanel.bird.wingUp();
			repaint();
			spacePressed = false;
		}
	}
	
}
