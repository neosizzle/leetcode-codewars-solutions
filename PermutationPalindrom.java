import java.util.HashSet;

public class PermutationPalindrom {
    public static void main(String args[]) {
        //a palindrome is a word that can be spelled same both forward and backwards
        //thus, it should have pairs of 2 of the same charcters in a word and/or a middle odd centre character
        //also applies to permutations of palidromes
        String str = "taC ocat";
        str = str.replaceAll("\\s+","").toLowerCase();
        HashSet<Character> unpaired = new HashSet<Character>();
        
        for(int i = 0; i < str.length(); i++){
            
            //if the current character has appeared an even amount of times/ paired
            if(unpaired.contains(str.charAt(i))){
                //remove the character
                unpaired.remove(str.charAt(i));
            }else{
                //if the current character has appeared an odd of times/ unpaired, add it to be paired
                unpaired.add(str.charAt(i));
            }
        }
        
        //in the end, there should be only maximum of 1 character unpaired for odd palindrome strings.
        //returns true if its palindrome/ permutation of palindrome
        System.out.println(unpaired.size() <= 1);
        
        
      
      
    }
}