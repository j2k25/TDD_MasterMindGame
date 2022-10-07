package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MasterMindTest {
	MasterMind mastermind;

	@BeforeEach
	public void setup() {
		mastermind = new MasterMind();
		Colors[] selectedColors = {Colors.BLACK, Colors.WHITE, Colors.GRAY, Colors.RED, Colors.BLUE, Colors.YELLOW};
		mastermind.setSelectedColors(selectedColors);
	}

	@Test
	public void Canary() {
		assertTrue(true);
	}

	@Test
	public void guessWithAllColorsMatched() {
		Colors[] guess = {Colors.BLACK, Colors.WHITE, Colors.GRAY, Colors.RED, Colors.BLUE, Colors.YELLOW};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(0, actual.nonPositionalMatches);
		assertEquals(6, actual.positionalMatches);
		assertEquals(0, actual.noMatches);
	}

	@Test
	public void guessWithFirstFourMatched() {
		Colors[] guess = {Colors.BLACK, Colors.WHITE, Colors.GRAY, Colors.RED, Colors.PINK, Colors.GREEN};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(0, actual.nonPositionalMatches);
		assertEquals(4, actual.positionalMatches);
		assertEquals(2, actual.noMatches);
	}

	@Test
	public void guessWithLastFourMatched() {
		Colors[] guess = {Colors.GREEN, Colors.MAGENTA, Colors.GRAY, Colors.RED, Colors.BLUE, Colors.YELLOW};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(0, actual.nonPositionalMatches);
		assertEquals(4, actual.positionalMatches);
		assertEquals(2, actual.noMatches);
	}

	@Test
	public void guessWithFirst3MatchedInAndLast2MatchedOut(){
		Colors[] guess = {Colors.BLACK, Colors.WHITE, Colors.GRAY, Colors.YELLOW, Colors.RED, Colors.PINK};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(2, actual.nonPositionalMatches);
		assertEquals(3, actual.positionalMatches);
		assertEquals(1, actual.noMatches);
	}

	@Test
	public void guessWithAllColorsMatchedOut(){
		Colors[] guess = {Colors.WHITE, Colors.BLACK, Colors.RED, Colors.GRAY, Colors.YELLOW, Colors.BLUE};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(6, actual.nonPositionalMatches);
		assertEquals(0, actual.positionalMatches);
		assertEquals(0, actual.noMatches);
	}

	@Test
	public void guessWith2ndMatchedInAndLast3MatchedOut(){
		Colors[] guess = {Colors.PINK, Colors.WHITE, Colors.GREEN, Colors.BLUE, Colors.YELLOW, Colors.RED};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(3, actual.nonPositionalMatches);
		assertEquals(1, actual.positionalMatches);
		assertEquals(2, actual.noMatches);
	}

	@Test
	public void guessWithNonColorMatching(){
		Colors[] guess = {Colors.PINK, Colors.GREEN, Colors.ORANGE, Colors.MAGENTA, Colors.MAGENTA, Colors.MAGENTA};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(0, actual.nonPositionalMatches);
		assertEquals(0, actual.positionalMatches);
		assertEquals(6, actual.noMatches);
	}

	@Test
	public void guessWith6RepeatedColors(){
		Colors[] guess = {Colors.BLACK, Colors.BLACK, Colors.BLACK, Colors.BLACK, Colors.BLACK, Colors.BLACK};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(0, actual.nonPositionalMatches);
		assertEquals(1, actual.positionalMatches);
		assertEquals(5, actual.noMatches);
	}

	@Test
	public void guessWithRepeated2To6Matched1stAnd1Matched2nd(){
		Colors[] guess = {Colors.WHITE, Colors.BLACK, Colors.BLACK, Colors.BLACK, Colors.BLACK, Colors.BLACK};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(2, actual.nonPositionalMatches);
		assertEquals(0, actual.positionalMatches);
		assertEquals(4, actual.noMatches);
	}

	@Test
	public void guessWithRepeated2To6Matched1stAnd1MatchedNone(){
		Colors[] guess = {Colors.PINK, Colors.BLACK, Colors.BLACK, Colors.BLACK, Colors.BLACK, Colors.BLACK};

		MatchResult actual = mastermind.guess(guess);

		assertEquals(1, actual.nonPositionalMatches);
		assertEquals(0, actual.positionalMatches);
		assertEquals(5, actual.noMatches);
	}

	@Test
	public void guessAfterASuccessfulGuess(){
		try{
			Colors[] selectedColors = {Colors.BLACK, Colors.WHITE, Colors.GRAY, Colors.RED, Colors.BLUE, Colors.YELLOW};

			mastermind.guess(selectedColors);
			mastermind.guess(selectedColors);
			fail("Expected exception after game is over");
		} catch (RuntimeException e){
			System.out.println("Exception caught: " + e);
		}
	}

	@Test
	public void guessAfter19IncorrectGuesses(){
		mastermind.guessCount = 19;
		Colors[] guess = {Colors.PINK, Colors.GREEN, Colors.ORANGE, Colors.MAGENTA, Colors.MAGENTA, Colors.MAGENTA};

		mastermind.guess(guess);
	}

	@Test
	public void guessAfter20IncorrectGuesses(){
		try{
			mastermind.guessCount = 20;
			Colors[] guess = {Colors.PINK, Colors.GREEN, Colors.ORANGE, Colors.MAGENTA, Colors.MAGENTA, Colors.MAGENTA};

			mastermind.guess(guess);
			fail("Expected exception after limit number of guesses");
		} catch (RuntimeException e){
			System.out.println("Exception caught: " + e);
		}
	}

	@Test
	public void guessAfter21IncorrectGuesses(){
		try{
			mastermind.guessCount = 21;
			Colors[] guess = {Colors.PINK, Colors.GREEN, Colors.ORANGE, Colors.MAGENTA, Colors.MAGENTA, Colors.MAGENTA};

			mastermind.guess(guess);
			fail("Expected exception after limit number of guesses");
		} catch (RuntimeException e){
			System.out.println("Exception caught: " + e);
		}
	}
}
