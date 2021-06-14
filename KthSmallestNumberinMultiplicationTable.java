// /https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
class Solution {
    public int findKthNumber(int m, int n, int k) {
        //we will pretend we have pupulated the grid with numbers and sorted them into an array
        //left and right are the bounds of the array
        //k >= 1, <= m*n
        int left = 1;
        int right = m * n;
        
        //this will do a binary search
        while(left < right){
            
            //declare mid pointer
            int mid = left + (right - left)/2;
            
            //if the number or elements at the left side of the array is more than k
            //we need to move the right pointer to the mid
            if(resAtLeft(mid , m, n, k)){
                right = mid;
            }else{
                //else, move left to mid exclusively
                left = mid + 1;
                
            }
            
        }
        
        //after the recursion, left pointer should be sitting at the result
        return left;
        
    }
    
    public boolean resAtLeft(int mid,int m, int n, int k){
        //the number of elemts at each row which are <= than mid can be determined by formula
        //Math.min(mid / i , n) where i is the current row
        
        int totalElems = 0;
        
        for(int i = 1; i <= m; ++i){
            totalElems += Math.min(mid / i , n);
        }
        
        //return true if total num of elemts <= mid is more than k, which means the value we are searching is on the left
        return totalElems >= k;
        
        
    }
}
