import java.util.*;
import java.io.*;

public class Problem1 {

    public static void main(String[] args) throws IOException {

		SpellChecker daCheck = new SpellChecker("words.txt");
		List<String> badWords = daCheck.getIncorrectWords(args[0]);

    	for(String word : badWords) {
			List<String> suggestions = daCheck.getSuggestions(word);
			System.out.print(word + " - ");
			for (String suggestion : suggestions) {
				System.out.print(suggestion + " ");
			}
			System.out.println();
		}
        
    }
}