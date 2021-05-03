//https://leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        HashSet<Character> chars = new HashSet<Character>();
        
        //error checking
        if(s == null || t == null){
            return false;
        }
        
        if(s.equals(t)){
            return true;
        }
        
        //add all chars in s to hashset
        for(int i = 0; i < s.length(); ++i){
            chars.add(s.charAt(i));
        }
   
        
        //declare two pointers
        int sPointer = 0;
        int tPointer = 0;
        
        while(tPointer < t.length()){
            
            //letter found in hashset
            if(chars.contains(t.charAt(tPointer))){
                //compare current char with char in s
                if(s.charAt(sPointer) == t.charAt(tPointer)){
                    ++sPointer;
                }
            }
            
            //return true if spointer has reached the end
            if(sPointer == s.length()){
                return true;
            }
            
            //increment t pointer
            ++tPointer;
        }
        
        //return false if t pointer has reached end
        return false;
        
        
        
    }
}
