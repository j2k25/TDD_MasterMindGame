package game.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import game.*;

public class MasterMindUI extends JFrame {
	static MasterMind mastermind;
	final int _numberOfColors = 10;
	final static int _numberOfGuess = 6;
	private static int playerScore;
	private int colorGuessedCount;
	private final Colors[] guess;
	static JFrame mainFrame;
	JPanel mainPanel;
	ArrayList<JButton> guessingButtonList;
	ArrayList<JButton> selectedColorsButtonList;
	JButton guessButton;
	JButton resetButton;
	JButton giveUpButton;
	JTextArea gameView;
	JPanel historyPanel;

	public static void main(String[] args) {
		playerScore = 0;
		mastermind = new MasterMind();
		mainFrame = new JFrame();
		new MasterMindUI();
	}

	static void restartGame(){
		mainFrame.dispose();
		mastermind = new MasterMind();
		mainFrame = new JFrame();
		new MasterMindUI();
	}

	private void gameOverLost() {
		colorGuessedCount = -1;
		showSelectedColors();
		JOptionPane.showMessageDialog(mainFrame, "You lost the game!");
		playerScore = 0;
		giveUpButton.setEnabled(false);
	}

	private void gameOverWin() {
		playerScore++;
		JOptionPane.showMessageDialog(mainFrame, "You won the game!!");
		colorGuessedCount = -1;
		giveUpButton.setEnabled(false);
		guessButton.setEnabled(false);
		resetButton.setEnabled(false);

	}


	private void resetGuess() {
		colorGuessedCount = 0;
		for(int i=0;i<_numberOfGuess;i++){
			guessingButtonList.get(i).setBackground(Color.lightGray);
			guessingButtonList.get(i).setText("Guess");
		}
		guessButton.setEnabled(false);
		resetButton.setEnabled(false);
	}

	private void showSelectedColors(){
		Colors[] selectedColors = mastermind.getSelectedColors();
		for(int i=0;i<_numberOfGuess;i++){
			selectedColorsButtonList.get(i).setText("");
			selectedColorsButtonList.get(i).setBackground(ColorButton.getColor(selectedColors[i]));
		}
	}

	class colorSelectingButtonClickHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(colorGuessedCount<6 && colorGuessedCount>=0){
				ColorButton buttonClicked = (ColorButton) e.getSource();
				Colors color = buttonClicked.getColorsObject();
				guess[colorGuessedCount] = color;
				guessingButtonList.get(colorGuessedCount).setBackground(ColorButton.getColor(color));
				guessingButtonList.get(colorGuessedCount).setText("");
				colorGuessedCount++;
			}
			if(colorGuessedCount > 0){
				resetButton.setEnabled(true);
			}
			if(colorGuessedCount == 6){
				guessButton.setEnabled(true);
			}
		}
	}

	public MasterMindUI() {
		int topPanelHeight = 300;
		int bottomPanelHeight = 300;
		JPanel topLeftPanel = new JPanel();
		topLeftPanel.setBackground(new Color(237,237,237));
		topLeftPanel.setBounds(0,0,250,topPanelHeight);
		topLeftPanel.setLayout(null);
		JPanel topRightPanel = new JPanel();
		topRightPanel.setBounds(250,0,600,topPanelHeight);
		topRightPanel.setLayout(null);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(0,topPanelHeight,850,bottomPanelHeight);
		bottomPanel.setLayout(null);
		
		historyPanel = new JPanel();
		historyPanel.setBackground(new Color(204, 229, 255));
		historyPanel.setBounds(850,0,350,640);
		historyPanel.setLayout(null);

		mainFrame.add(topLeftPanel);
		mainFrame.add(topRightPanel);
		mainFrame.add(bottomPanel);
		mainFrame.add(historyPanel);
	
		JLabel gameInfo = new JLabel("Your Score: " + playerScore);
		gameInfo.setFont(new Font("Arial",Font.BOLD,27));
		gameInfo.setForeground(new Color(0, 0, 204));
		gameInfo.setBounds(30,50,200,50);
		topLeftPanel.add(gameInfo);

		gameView = new JTextArea();
		gameView.setFont(new Font("Arial",Font.ITALIC,16));
		gameView.setForeground(Color.blue);
		gameView.setBackground(new Color(237,237,237));
		gameView.setEditable(false);
		gameView.setBounds(30,125,250,200);
		gameView.setText("Pick some colors");
		topLeftPanel.add(gameView);

		Colors[] availableColors = {Colors.BLACK, Colors.WHITE, Colors.GRAY, Colors.RED, Colors.BLUE, Colors.YELLOW, Colors.PINK, Colors.GREEN, Colors.ORANGE, Colors.MAGENTA};
		for(int i=0;i<_numberOfColors;i++){
			JButton colorButton = new ColorButton(availableColors[i]);
			colorButton.setBounds(40+(i%5)*100,75+(i/5)*100,75,75);
			topRightPanel.add(colorButton);
			colorButton.addActionListener(new colorSelectingButtonClickHandler());
		}
		
		guessingButtonList = new ArrayList<JButton>();
		for(int i=0;i<_numberOfGuess;i++){
			JButton newGuessingButton = new ColorButton(Colors.NONE);
			newGuessingButton.setEnabled(false);
			newGuessingButton.setText("Guess");
			newGuessingButton.setBounds(i*100+40,50,85,125);
			guessingButtonList.add(newGuessingButton);
			bottomPanel.add(newGuessingButton);
		}

		selectedColorsButtonList = new ArrayList<JButton>();
		for(int i=0;i<_numberOfGuess;i++){
			JButton newSelectedColorsButton = new ColorButton(Colors.NONE);
			newSelectedColorsButton.setEnabled(false);
			newSelectedColorsButton.setBounds(i*100+40,225,85,40);
			selectedColorsButtonList.add(newSelectedColorsButton);
			bottomPanel.add(newSelectedColorsButton);
		}

		guessButton = new JButton("Guess");
		guessButton.addActionListener(e -> compareGuess());
		guessButton.setEnabled(false);
		guessButton.setBounds(650, 50, 175, 75);
		bottomPanel.add(guessButton);

		resetButton = new JButton("Reset");
		resetButton.addActionListener(e -> resetGuess());
		resetButton.setEnabled(false);
		resetButton.setBounds(650, 135, 175, 40);
		bottomPanel.add(resetButton);
		
		giveUpButton = new JButton("Give Up");
		giveUpButton.addActionListener(e -> gameOverLost());
		giveUpButton.setBounds(650, 225, 85, 40);
		bottomPanel.add(giveUpButton);
		
		JButton newGameButton = new JButton("Restart");
		newGameButton.addActionListener(e -> restartGame());
		newGameButton.setBounds(740, 225, 85, 40);
		bottomPanel.add(newGameButton);

		mainFrame.setSize(1200, 640);
		mainFrame.setTitle("Master Mind");
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		guess = new Colors[6];
		colorGuessedCount = 0;
		for(int i = 0; i < guess.length; i++){
			guess[i] = Colors.NONE;
		}
	}

	public void compareGuess() {
		MatchResult matchResult = mastermind.guess(guess.clone());
		if(mastermind.isWin()){
			gameOverWin();
			return;
		}
		else if(mastermind.isLost()){
			gameOverLost();
			return;
		}
		else{
			String resultMessage = "You have:\n"
			+ matchResult.positionalMatches + " colors in correct position\n"
			+ matchResult.nonPositionalMatches + " colors in incorrect position";
			gameView.setText(resultMessage);

		}

		int currentYPos = mastermind.guessCount*30 - 17;
		for(int i = 0; i < _numberOfGuess; i++){
			JButton historyColorButton = new ColorButton(guess[i]);
			historyColorButton.setBounds(40+i*30, currentYPos + 5, 20, 10);
			historyColorButton.setEnabled(false);
			historyPanel.add(historyColorButton);			
		}

		JPanel blackPanel = new JPanel();
		blackPanel.setBackground(Color.BLACK);
		blackPanel.setBounds(250, currentYPos, 30, 20);
		JPanel silverPanel = new JPanel();
		silverPanel.setBackground(Color.GRAY);
		silverPanel.setBounds(290, currentYPos, 30, 20);
		historyPanel.add(silverPanel);

		JLabel blackFeedback = new JLabel(""+matchResult.positionalMatches);
		blackFeedback.setForeground(Color.WHITE);
		blackPanel.add(blackFeedback);
		JLabel silverFeedback = new JLabel(""+matchResult.nonPositionalMatches);
		silverFeedback.setForeground(Color.WHITE);
		silverPanel.add(silverFeedback);
		
		historyPanel.add(blackPanel);
		historyPanel.add(silverPanel);
		historyPanel.repaint();
		resetGuess();
	}
}
