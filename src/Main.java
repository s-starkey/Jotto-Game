import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		Sleep pause = new Sleep();
		WordBank bank = new WordBank();
	
		
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
					String guess = stringConsole.next();
					System.out.println(bank.checkWord(guess));
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
