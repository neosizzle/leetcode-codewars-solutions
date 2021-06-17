//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int minSwaps = 0;
        
        //the dominoes can have a valid combination under 4 possilibities
        
        //all dominoes in tops is the value of tops[0]
        //all dominoes in bottoms is the value of tops[0]
        minSwaps = Math.min(getMinSwaps(tops[0] , tops, bottoms) , getMinSwaps(bottoms[0] , tops, bottoms));
        
        
        //all dominoes in top are equal to the value of bottoms[0]
        minSwaps = Math.min(minSwaps, getMinSwaps(tops[0] , bottoms, tops));
        
        //all dominoes in bottoms are equal to the value of bottoms[0]
        minSwaps = Math.min(minSwaps,getMinSwaps(bottoms[0] , bottoms, tops));
        
        //after going thru all the possibilities, return minswaps if its valid
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }
    
    public int getMinSwaps(int target , int[] arrToMatchTarget, int[]otherArr){
        int swaps = 0;
        
        //linear traversal
        for(int i = 0; i < arrToMatchTarget.length; ++i){
            //check if rotation on current domino is valid
            if(arrToMatchTarget[i] != target && otherArr[i] != target){
                
                //invalid rotation, return max value for invalid combonation
                return Integer.MAX_VALUE;
                
            }else if(arrToMatchTarget[i] != target && otherArr[i] == target){
                //other array has target and current arr dosnt, a swap is needed
                ++swaps;
                
            }
        }
        
        return swaps;
        
    }
}
