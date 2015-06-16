import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		Sleep pause = new Sleep();
		WordBank bank = new WordBank();
		GuessList pastGuesses = new GuessList();
	
		
		int choice;
		String proposedWord;
		Scanner console = new Scanner(System.in);
		Scanner stringConsole = new Scanner(System.in);
		System.out.println("**********************************");
		System.out.println("*                                *");
		System.out.println("*       WELCOME TO JOTTO         *");
		System.out.println("*                                *");
		System.out.println("**********************************");
		
		
		
		do{
			System.out.println("1) Play Jotto");
			System.out.println("2) Add a word to the Word Bank");
			System.out.println("3) Display the Word Bank");
			System.out.println("0) Exit");
			System.out.print("What would you like to do?");
			choice = console.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("Selecting a word...");
				pause.hold(1000);
				String secret = bank.getWord();
				if (secret == null){
					System.err.println("There are no more words in the Word Bank\n");
				}else{
					System.out.println("Ok, I have a word.\nMake your first guess.");
					int response;
					do{
						Guess newGuess = new Guess();
						String guess = stringConsole.next();
						response = bank.checkWord(guess);
						newGuess.setGuessedWord(guess);
						newGuess.setMatches(response);
						if (response == -1){
						
						}else if(response == 1){
							pastGuesses.add(newGuess);
							System.out.println("You matched " + response + " letter");
							System.out.println("Guess Again");
							pastGuesses.toString();
						}else{
							pastGuesses.add(newGuess);
							System.out.println("You matched " + response + " letters");
							System.out.println("Guess Again");
							pastGuesses.toString();
						}
						
						
					}while(response != -1);
				}
				
				
				break;
			case 2:
				System.out.println("Enter the word you would like to add: ");
				proposedWord = stringConsole.next();
				bank.addWord(proposedWord);
				break;
			case 3:
				bank.toString();
				break;
			case 0:
				System.out.println("zero");
				bank.updateWordBank();
				break;
			}
			pause.hold(1000);
			System.out.println();
		}while(choice != 0);
				
		console.close();
		stringConsole.close();
	}

	
	
}
