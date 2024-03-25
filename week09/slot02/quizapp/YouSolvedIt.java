package week09.slot02.quizapp;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YouSolvedIt extends JPanel {

	JButton yesButton = new JButton("Yes"),
			noButton = new JButton("No");
	
	public YouSolvedIt() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("You Solved It."));
		this.add(new JLabel("Try again?"));
		this.add(yesButton);
		this.add(noButton);
		yes();
		no();
	}

	private void no() {
		noButton.addActionListener(e -> {
			System.exit(0);
		});
	}

	private void yes() {
		yesButton.addActionListener(e -> {
			MainApp.primaryFrame.getContentPane()
				.removeAll();
			AdditionQuiz aq = new AdditionQuiz();
			MainApp.primaryFrame.getContentPane()
				.add(aq);
			MainApp.primaryFrame.getContentPane()
				.revalidate();
			MainApp.primaryFrame.getContentPane()
				.repaint();
		});
	}
	
}
