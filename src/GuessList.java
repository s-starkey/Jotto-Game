import java.util.ArrayList;

public class GuessList {
	ArrayList<Guess> guesses = new ArrayList<Guess>();
	
	
	public void add(Guess newGuess) {
		guesses.add(newGuess);
		
	}	
	
public String toString(){
	for (Guess guess : guesses){
		System.out.printf("Guess: %s\tMatches: %d\n", guess.getGuessedWord(), guess.getMatches());
	}
	return "";
}






	
}
