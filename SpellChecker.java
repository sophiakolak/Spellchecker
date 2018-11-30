import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellChecker{
    
    HashSet<String> h = new HashSet<String>();
    
    //hashing words in the dictionary
    
    SpellChecker(String DictFileName){
        if (DictFileName == null)
        {
            
            System.out.println("Sorry you must add a real file");
            
        }
        else
        {
            
            File givenFile = new File(DictFileName);
            try
                
            {
                
                int lineNumber = 0;
                String[] stringArray;
                Scanner scanWords = new Scanner(givenFile);
                while(scanWords.hasNext())
                {                   
                    lineNumber++;  
                    String currentLine = scanWords.nextLine().toLowerCase();
                    
                    //makes sure individual letters aren't added
                    //unless they are actual words in the case of i and a 
                    
                    if (currentLine.length() == 1){
                        if (currentLine.charAt(0) == 'i' || currentLine.charAt(0) == 'a'){
                            h.add(currentLine);
                        }
                    }
                    else
                    {
                        h.add(currentLine);
                    }
                }
            }
            
        catch(FileNotFoundException a)
            
        {
            a.printStackTrace();
        }
    }
        
   }
    
    
   public List<String> getIncorrectWords(String filename){
     
       List<String> fakeWords = new LinkedList<>();
       
       if (filename == null)
       {
           
           System.out.println("Sorry you must add a real file");
           
       }
       
       else
       {
            File givenFile = new File(filename);
            try
            {
                int lineNumber = 0;
                String[] stringArray;
                Scanner scanWords = new Scanner(givenFile);
                while(scanWords.hasNext())
                {
                    
                    lineNumber++;  
                    String currentLine = scanWords.nextLine().toLowerCase();
                    
                    //removes empty lines 
                   
                    if ("".equals(currentLine.trim()))
                    {
                        //do nothing this line empty yeet 
                    }
                    
                    //if the line is not empty 
                    
                    else
                    {
                        
                        stringArray = currentLine.split(" ");
                        for (int i = 0; i < stringArray.length; i++)                        
                        {    
                            String maybeValid = checkWord(stringArray[i]); 
                            if (!h.contains(maybeValid))
                            {
                                
                                fakeWords.add(maybeValid);
                                
                            }
                        }
                    }
                }
                
            }
           
            catch(FileNotFoundException a)
            {
                
               a.printStackTrace();
                
            }
       }
       
   return fakeWords;
       
   } 
    
   //This method checks if the first/last characters are alphanumeric 
   //if both or either of them are, they get stripped. 
   //if neither are, then the original word is returned 
   //this way, the method can be called on every word and will only effect
   //the ones that have non-alphanumeric symbols.
    
   public String checkWord(String word){
       if (word.length() > 1){
           if (!Character.isLetterOrDigit(word.charAt(0)) && 
           !Character.isLetterOrDigit(word.charAt(word.length()-1)) )
           {
               return word.substring(1, word.length() - 1);
           
           }
           else if (!Character.isLetterOrDigit(word.charAt(0)) )
           {
               return word.substring(1);
           
           }
           else if (!Character.isLetterOrDigit(word.charAt(word.length()-1)) )
           {
               return word.substring(0, word.length() - 1);
           
           }
       }
       
   return word;
       
   }
    
   public List<String> getSuggestions(String word){
       
       List<String> suggestions = new LinkedList<>();       
       StringBuilder dankWord = new StringBuilder(word);
       
       //these nested for loops try every letter of the alphabet 
       //at every index in the word 
       
       for (int i = 0; i < dankWord.length()+1; i++)
       {
           
           for (int j = 0; j < 26; j++)
           {
               
               StringBuilder temp = new StringBuilder(word);
               char lower = (char) ('a' + j);
               String maybeValid = temp.insert(i, lower).toString();
               
               if (h.contains(maybeValid))
               {
                   
                   suggestions.add(maybeValid);
                   
               }
           }
           
       }
       
       //this for loop checks if a valid word is created 
       //when you try deleting the character at each index
       
       for (int i = 0; i < dankWord.length(); i++)
       {
           
           StringBuilder temp = new StringBuilder(word);
           String maybeValid = temp.deleteCharAt(i).toString();
           
               if (h.contains(maybeValid))
               {
                        
                   suggestions.add(maybeValid);
                        
               }
                   
       }
       
       //this for loop checks if swapping to adjacent letters 
       //(at any position) would create a valid word
       
       for (int i = 0; i < dankWord.length()-1; i++)
       {
           StringBuilder yay = new StringBuilder(word);
           yay.setCharAt(i, word.charAt(i+1));
           yay.setCharAt(i+1, word.charAt(i));
           String maybeValid = yay.toString();
           if (h.contains(maybeValid))
           {
               
               suggestions.add(maybeValid);
               
           }
                   
       } 
       
  return suggestions;
       
  }
    
    
}