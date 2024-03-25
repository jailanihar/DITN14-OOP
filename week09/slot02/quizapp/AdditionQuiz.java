package week09.slot02.quizapp;

import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdditionQuiz extends JPanel {

	JPanel equationPanel = new JPanel();
	JLabel leftValueLabel = new JLabel(),
			rightValueLabel = new JLabel(),
			counterLabel = new JLabel("" + 0);
	JTextField answerTextField = new JTextField();
	JButton answerButton = new JButton("Answer");
	Random random = new Random();
	int leftValue, rightValue, counter;
	
	public AdditionQuiz() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		equationPanel.setLayout(
			new BoxLayout(equationPanel, BoxLayout.X_AXIS));
		
		generateQuiz();
		
		equationPanel.add(leftValueLabel);
		equationPanel.add(new JLabel("+"));
		equationPanel.add(rightValueLabel);
		equationPanel.add(new JLabel("="));
		equationPanel.add(answerTextField);
		this.add(equationPanel);
		this.add(answerButton);
		this.add(new JLabel(
				"Current consecutive correct answer"));
		this.add(counterLabel);
		answer();
	}

	private void answer() {
		answerButton.addActionListener(e -> {
			String answerString = answerTextField.getText();
			int answer = Integer.parseInt(answerString);
			if(answer == (leftValue + rightValue)) {
				counter++;
				if(counter >= 5) {
					// Change to YouSolvedIt page
					MainApp.primaryFrame.getContentPane()
						.removeAll();
					YouSolvedIt ysi = new YouSolvedIt();
					MainApp.primaryFrame.getContentPane()
						.add(ysi);
					MainApp.primaryFrame.getContentPane()
						.revalidate();
					MainApp.primaryFrame.getContentPane()
						.repaint();
				}
			} else {
				counter = 0;
			}
			counterLabel.setText("" + counter);
			answerTextField.setText("");
			generateQuiz();
		});
	}

	private void generateQuiz() {
		leftValue = random.nextInt(10);
		rightValue = random.nextInt(10);
		leftValueLabel.setText("" + leftValue);
		rightValueLabel.setText("" + rightValue);
	}
	
	
	
}
