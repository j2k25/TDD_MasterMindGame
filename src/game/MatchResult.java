package game;

public class MatchResult {
	public final int nonPositionalMatches;
	public final int positionalMatches;
	public final int noMatches;

	MatchResult(int noMatches, int nonPositionalMatches, int positionalMatches){
		this.nonPositionalMatches = nonPositionalMatches;
		this.positionalMatches = positionalMatches;
		this.noMatches = noMatches;
	}
}
