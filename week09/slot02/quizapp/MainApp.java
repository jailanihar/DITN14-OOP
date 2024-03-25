package week09.slot02.quizapp;

import javax.swing.JFrame;

public class MainApp {

	public static JFrame primaryFrame;
	
	public static void main(String[] args) {
		primaryFrame = new JFrame("Quiz App");
		
		AdditionQuiz aq = new AdditionQuiz();
		primaryFrame.getContentPane().add(aq);
		
		primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		primaryFrame.pack();
		primaryFrame.setVisible(true);
	}
	
}
