//https://leetcode.com/problems/find-the-highest-altitude/
class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int sum = 0;
        
        for(int i = 0; i < gain.length; ++i){
            //find the sum of two adjacent elements of array
            sum += gain[i];
            
            //return the max of of the sum compared to prev sum
            res = Math.max(res , sum);
        }
        return res;
        
        
        

        
    }
}
