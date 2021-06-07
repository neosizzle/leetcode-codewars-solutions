//https://leetcode.com/problems/repeated-dna-sequences/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();//hashset to store occured substrings
        HashSet<String> ans = new HashSet<>();//hashset to store occured answers
        
  
        
        //if the string length is 10, there are no extra subsequences
        if(s.length() <= 10){
            return res;
        }
        
        //walk through the string
        for(int i  = 0, j = 10; j <= s.length(); ++i , ++j){
            //use 2 pointers with difference 10 because the substrings are constant length 10
            String temp = s.substring(i,j);
            
            //see if string exists in hashset
            if(hashSet.contains(temp) && !ans.contains(temp)){
                //if yes, which means its repeated, add into res nad ans hashset
                ans.add(temp);
                res.add(temp);
            }else{
                //else, add into hashset to create new entry
                hashSet.add(temp);
            }
            
           
        }
        
        return res;
        
    }
}
