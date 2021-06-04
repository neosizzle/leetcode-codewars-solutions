//https://leetcode.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
       //declare initial random result to compare
        int res = nums[0] + nums[1] + nums[2];
        
        //sort the arr so we can use 2 poitners method
        Arrays.sort(nums);
        
        //traversing the loop linearly
        for(int i = 0; i < nums.length - 2; ++i){
            //declare two pointers here, i is our thirs pointer
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;
            
            
            //while the two pointers havent meet, do sth
            while(rightIdx > leftIdx){
                //get the current sum of the pointers
                int currSum = nums[i] + nums[rightIdx] + nums[leftIdx];
                
                //if the current sum is more than target, we can move right index closer to center, vice versa for left idx
                if(currSum > target){
                    rightIdx--;
                }
                else{
                    leftIdx++;
                }
                
                //compare current sum value with result, if the differene is smaller then update res
                if(Math.abs(target - currSum) < Math.abs(res - target)){
                    res = currSum;
                }
            }
            
            
        }
        
        return res;
        
        
    }
    

}
