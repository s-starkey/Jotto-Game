import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;



/**
 * @author sstarkey
 *
 */
public class WordBank {
	
	private String chosenWord;
	private ArrayList<String> words = new ArrayList<String>();
	private Path path = FileSystems.getDefault().getPath("List_of_Words.txt");

	public WordBank(){ 
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	words.add(line);
		        //System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	
	/**
	 * Add a word to the Word Bank if it does not already exist.<br>
	 * If the word is in the Word Bank an error message is displayed
	 * @param 
	 */
	public void addWord(String aWord){
		boolean flag = false;
		for (String entry : words){
			if(aWord.equals(entry)){
				flag = true;
			}
		}
		if (flag == true){
			System.err.printf("I am sorry but %s is already in the Word Bank\n", aWord);
		}else{
			System.out.printf("%s has been added to the Word Bank\n", aWord);
			words.add(aWord);
		}
	}
	
	
	/**
	 * Used to write added words back to the Word Bank file
	 */
	public void updateWordBank(){
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			java.util.Iterator<String> wordsIterator = words.iterator();
			while(wordsIterator.hasNext()){
				String s = wordsIterator.next();
				writer.write(s, 0, s.length());
				writer.write("\r\n");
			}
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	
	
	/**
	 * Select and remove the last item in the Word Bank
	 * if there is one
	 * @return String
	 */
	public String getWord(){
		String selected;
		if(!words.isEmpty()){
			selected = words.remove(words.size()-1);
			this.chosenWord = selected;
		}else{
			
			selected = null;
		}
		return selected;
	}
	
	
	
	/**
	 * Gets the chosen word that players are trying to guess
	 * @return String
	 */
	public String getChosen(){
		return this.chosenWord;
	}
	
	
	public Set<Character> uniqueCharacters(String guess){
		//char[] guessSet = new char[guess.length()];
		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<guess.length(); i++){
			set.add(guess.charAt(i));
		}
		//System.out.println(set);
		return set;
		
	}
	
	
	/**
	 * Player takes a guess at the secret word
	 * @param guess
	 */
	public int checkWord(String guess){
		int count = 0;
		String secretWord = getChosen();
		//System.out.println("Secret Word " + secretWord);
		if (guess.equalsIgnoreCase(secretWord)){
			System.out.println("WOW! I can't believe you got it!\nYOU WIN!");
			return -1;
		}else{
			//System.out.println(guess);
			//System.out.println(uniqueCharacters(guess));
			for (char s : (uniqueCharacters(guess))) {
				for(int j=0; j<secretWord.length(); j++){
					if(s == secretWord.charAt(j)){
						count++;
						
					}
				}
			}
		}
		
		return count;
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		for (String word : words){
			System.out.printf("%s\n", word);
		}
		return "";
	}
	
	
	
}
