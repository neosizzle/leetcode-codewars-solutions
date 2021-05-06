//https://leetcode.com/problems/decode-ways/
class Solution {
    public int numDecodings(String s) {
        //create dp array to store the number of ways to decode for for length n.
        //dp[0]s value = number of ways to decode string of length 0
        int stringLength = s.length();
        int[] dp = new int[stringLength + 1];

        //number of ways to decode a string length of 0 is 1
        //If there's nothing in the string, the only way to decode it is by not decoding it. Which counts  as one way.
        dp[0] = 1;
        
        //number of ways to decode string of length 1 is depending on the first character is a valid  character
        dp[1] = s.charAt(0) != '0'? 1 : 0;
        
        //start iterating through the array to find solutions for its length
        for(int i = 2; i <= stringLength ; ++i){
            //gets the single digit at index i
            int singleDigit = Integer.valueOf(s.substring(i - 1, i));
            
            //gets the double digit at index i
            int doubleDigit = Integer.valueOf(s.substring(i - 2, i));
            
            //now we got our digits at index i, we should check if they are valid or not.
            if(singleDigit >= 1 && singleDigit <= 9){
                //we can safely add the number of ways to solve the last digit into the number of ways to solve the current digit
                
                dp[i] += dp[i-1];
            }
            
            if(doubleDigit >= 10 && doubleDigit <= 26){
                //we can safely add the number of ways to solve the second last digit into the number of ways to solve the current digit
    
                dp[i] += dp[i-2];
            }
            
        }
        
        //after the traversal is done, dp[stringLength] should contain number of ways to solve s with length stringLength
        
        return dp[stringLength];
    }
}
