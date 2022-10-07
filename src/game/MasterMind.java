package game;

import java.util.*;

public class MasterMind {
	private Colors[] selectedColors;
	private boolean win;
	private final boolean lose;
	public int guessCount;
	final int _numberOfGuessAllowed = 20;

	public MasterMind(){
		win = false;
		lose = false;
		guessCount = 0;
		selectedColors = new Colors[6];
		generateSelectedColors();
	}

	private void generateSelectedColors(){
		List<Colors> allColorsList =  new ArrayList<Colors>();
		allColorsList = Arrays.asList(Colors.values());
		List<Colors> selectedColorsList =  new ArrayList<Colors>();
		Random random = new Random();

		for(int i = 0; i < 6; i++){
			Colors newRandomColors = allColorsList.get(random.nextInt(10)+1);
			while(selectedColorsList.contains(newRandomColors)){
				newRandomColors = allColorsList.get(random.nextInt(10)+1);
			}
			selectedColorsList.add(newRandomColors);
		}
		selectedColors = selectedColorsList.toArray(selectedColors);
	}

	public void setSelectedColors(Colors[] answer) {
		this.selectedColors = answer;
	}

	public MatchResult guess(Colors[] guess) {
		if (isWin() || isLost()) {
			throw new RuntimeException("Game is already over");
		}
		int noMatches = 0;
		int nonPositionalMatches = 0;
		int positionalMatches = 0;
		Colors[] selectedColorsCopy = selectedColors.clone();
		for (int i = 0; i < 6; i++){
			if (guess[i] == selectedColorsCopy[i]) {
				positionalMatches++;
				guess[i] = Colors.NONE;
				selectedColorsCopy[i] = Colors.NONE;
			}
		}
		for (int guessIndex = 0; guessIndex < guess.length; guessIndex++) {
			for (int answerIndex = 0; answerIndex < selectedColorsCopy.length; answerIndex++) {
				if (guess[guessIndex] != Colors.NONE && guess[guessIndex] == selectedColorsCopy[answerIndex]) {
					nonPositionalMatches++;
					guess[guessIndex] = Colors.NONE;
					selectedColorsCopy[answerIndex] = Colors.NONE;
					break;
				}
			}
		}
		noMatches = 6-nonPositionalMatches-positionalMatches;
		if(positionalMatches == 6){
			win = true;
		}
		guessCount++;
		return new MatchResult(noMatches, nonPositionalMatches, positionalMatches);
	}

	public boolean isWin(){
		return win;
	}
	public boolean isLost(){
		return lose || guessCount >= _numberOfGuessAllowed;
	}

	public Colors[] getSelectedColors() {
		return selectedColors;
	}
}
