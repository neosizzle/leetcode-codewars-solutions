//https://leetcode.com/problems/longest-palindromic-substring/
class Solution {

    int resultStart;
    int resultLength;

    public String longestPalindrome(String s) {
        
        //constraint checking 
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }
        
        //traverse the string linearly
        for (int start = 0; start < strLength - 1; start++) {
            //calling two times for even string cases
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        
        return s.substring(resultStart, resultStart + resultLength);
    }

    //helper method to find the longest substring given the middle index of string
    private void expandRange(String str, int begin, int end) {
        
        //keep expanding as long as both indexes have equal values and pointer still in string
       while (begin >= 0 && end < str.length() &&
                    str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        
     
    //zero indexing gay
    //compare global result length with the result length we got from indexes
       if (resultLength < end - begin - 1) {
           //set new result start and new result length we have find a longer substring
           
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}
