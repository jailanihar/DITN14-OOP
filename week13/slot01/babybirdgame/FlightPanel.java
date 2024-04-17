package week13.slot01.babybirdgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FlightPanel extends JPanel {

	final int WIDTH = 600, HEIGHT = 600;
	BirdPanel bird;
	Timer timer;
	boolean gameStart = false;
	boolean gameOver = false;
	Random random = new Random();
	LinkedList<JPanel> topWalls = new LinkedList<JPanel>();
	LinkedList<JPanel> bottomWalls = new LinkedList<JPanel>();
	
	public FlightPanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.GREEN);
		
		bird = new BirdPanel();
		bird.setBounds(10, 
				HEIGHT / 2,
				bird.getPreferredSize().width,
				bird.getPreferredSize().height);
		
		generateWall(250);
		generateWall(500);
		generateWall(750);
		
		timer = new Timer(30, e -> {
			if(gameStart == true && gameOver == false) {				
				bird.setBounds(
						10,
						bird.getBounds().y + 5,
						bird.getPreferredSize().width,
						bird.getPreferredSize().height
						);
				moveWalls();
				tryAddNewWall();
				birdOutOfBound();
				updateScore();
				if(gameOver == true) {
					restartGame();
				}
			}
		});
		timer.start();
		
		this.add(bird);
	}

	private void updateScore() {
		GamePanel.score++;
		GamePanel.scorePanel.updateScore(GamePanel.score);
	}

	private void tryAddNewWall() {
		if(topWalls.getFirst().getBounds().getMaxX() < 0) {
			JPanel topWall = topWalls.removeFirst();
			JPanel bottomWall = bottomWalls.removeFirst();
			
			this.remove(topWall);
			this.remove(bottomWall);
			
			int lastTopWallX =
					(int) topWalls.getLast().getBounds().getMinX();
			generateWall(lastTopWallX + 250);
		}
	}

	private void moveWalls() {
		for(JPanel topWall : topWalls) {
			topWall.setBounds(
					topWall.getBounds().x - 5,
					topWall.getBounds().y,
					topWall.getBounds().width,
					topWall.getBounds().height
					);
			if(bird.getBounds().intersects(topWall.getBounds())) {
				gameOver = true;
			}
		}
		for(JPanel bottomWall : bottomWalls) {
			bottomWall.setBounds(
					bottomWall.getBounds().x - 5,
					bottomWall.getBounds().y,
					bottomWall.getBounds().width,
					bottomWall.getBounds().height
					);
			if(bird.getBounds().intersects(bottomWall.getBounds())) {
				gameOver = true;
			}
		}
	}

	private void generateWall(int x) {
		int topHeight = random.nextInt(250) + 100;
		JPanel topWall = new JPanel();
		topWall.setBounds(x, 0, 50, topHeight);
		topWall.setBackground(Color.BLACK);
		this.add(topWall);
		topWalls.add(topWall);
		
		int bottomHeight = HEIGHT - (topHeight + 150);
		JPanel bottomWall = new JPanel();
		bottomWall.setBounds(x, topHeight + 150, 50, bottomHeight);
		bottomWall.setBackground(Color.BLACK);
		this.add(bottomWall);
		bottomWalls.add(bottomWall);
	}

	private void restartGame() {
		GamePanel.prevScore = GamePanel.score;
		GamePanel.score = 0;
		Container container = BabyBirdGame.frame.getContentPane();
		container.removeAll();
		container.add(new GamePanel());
		container.revalidate();
		container.repaint();
	}

	private void birdOutOfBound() {
		if(bird.getBounds().getMinY() < 0 ||
				bird.getBounds().getMaxY() > HEIGHT) {
			gameOver = true;
		}
//		if(bird.getBounds().getMinY() < 0) {
//			bird.setBounds(
//					10,
//					0,
//					bird.getPreferredSize().width,
//					bird.getPreferredSize().height
//					);
//		}
//		if(bird.getBounds().getMaxY() > HEIGHT) {
//			bird.setBounds(
//					10,
//					HEIGHT - bird.getPreferredSize().height,
//					bird.getPreferredSize().width,
//					bird.getPreferredSize().height
//					);
//		}
	}
	
}
