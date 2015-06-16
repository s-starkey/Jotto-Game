public class Guess {
	private String guessedWord;
	private int matches;
	
	public Guess(String aGuess, int matched){
		this.guessedWord = aGuess;
		this.matches = matched;
	}
	
	public Guess() {

	}



	public String getGuessedWord() {
		return guessedWord;
	}

	public void setGuessedWord(String guessedWord) {
		this.guessedWord = guessedWord;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}
	
}
