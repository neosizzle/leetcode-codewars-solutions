//https://leetcode.com/problems/bag-of-tokens/
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        //sort the array so we get access to largest and smallest tokens
        Arrays.sort(tokens);
        
        //declare max score and surrence score
        int score = 0;
        int maxScore = 0;
        
        //declare min and max pointers/ left n right
        int minPointer = 0;
        int maxPointer = tokens.length - 1;
        
        //while the pointers dont meet/ still tokens unprocessed, do sth
        while(minPointer <= maxPointer){
            //if the current power is greater than our smallest token
            if(power >= tokens[minPointer]){
                //trade in that token and increase the score
                ++score;
                power -= tokens[minPointer];
                
                //token used, moving min pointer forwards
                ++minPointer;
                
                maxScore = Math.max(score , maxScore);
                
            }else if(score > 0){
                //if we dont have enough power to trade in a score, 
                //and we have spare score, we trade the score for the maximum power
                
                --score;
                power += tokens[maxPointer];
                
                //token used, moving max ptr backwards
                --maxPointer;
                
            }else{
                //no power + no score, game over :(
                return maxScore;
            }
            
            
        }
        
        return maxScore;
        
    }
}
