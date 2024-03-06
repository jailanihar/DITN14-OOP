package week07.slot01.introtogui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColourChanger {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Colour Changer");
		
		JLabel label = new JLabel("This is where the colour changes.");
		label.setOpaque(true);
		label.setBackground(Color.PINK);
		
		frame.getContentPane().add(label);
		
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_Y) {
					label.setBackground(Color.YELLOW);
				} else if(e.getKeyCode() == KeyEvent.VK_B) {
					label.setBackground(Color.BLUE);
				} else if(e.getKeyCode() == KeyEvent.VK_R) {
					label.setBackground(Color.RED);
				} else {
					label.setBackground(Color.BLACK);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				label.setBackground(Color.PINK);
			}
		});
		
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
