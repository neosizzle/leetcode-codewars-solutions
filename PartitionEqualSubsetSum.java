//https://leetcode.com/problems/partition-equal-subset-sum/
class Solution {
    public boolean canPartition(int[] nums) {
        //check if total sum is odd or even, if odd, means we cant split
        int totalSum = 0;
        for(int i : nums){
            totalSum += i;
        }
        
        if(totalSum % 2 != 0){
            return false;
        }
        
        //helper function
        return canPartition(nums, 0 , 0, totalSum , new HashMap<String,Boolean>());
        
    }
    
    public boolean canPartition(int[] nums, int index , int currentSum, int totalSum, HashMap<String,Boolean> state){
        //generate state for memorization
        String stateStr = index + "" + currentSum;
        
        //if the state is inside our memorization hashmap, return its result
        if(state.containsKey(stateStr)){
            return state.get(stateStr);
        }
        
        
        //the idea is, if one of our subsets sum is equals to total / 2, the other subset sum will be equal the same number as well.           //base case, if sum * 2 == total return true, we found our subset
        if(currentSum * 2 == totalSum){
            return true;
        }
        
        //if sum * 2 > total retrun false, subset limit exceeded
        if(currentSum * 2 > totalSum || index >= nums.length){
            return false;
        }
        
        
        //make a recursive call stimulating taking that number by adding it to sum
        
        //or not taking the number but incrementing index but not adding it to sum
        boolean result = canPartition(nums,index + 1, currentSum + nums[index], totalSum , state) || canPartition(nums,index + 1, currentSum, totalSum, state);
        
        //store state in memory
        state.put(stateStr , result);
        
        return result;
        
        
    }
}
