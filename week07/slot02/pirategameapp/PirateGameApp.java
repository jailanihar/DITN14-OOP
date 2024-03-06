package week07.slot02.pirategameapp;

import javax.swing.JFrame;

public class PirateGameApp {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pirate Game");
		
		MainGamePanel mgp = new MainGamePanel();
		frame.getContentPane().add(mgp);
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
