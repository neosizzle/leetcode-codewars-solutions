//https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/submissions/
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        //declare new arr length
       int n = nums.length;
        int[] res = new int[n];
        
        //declare variables needed for formula
        int sumBelow = 0;
        int sumTotal = Arrays.stream(nums).sum();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            sumTotal -= num;
            
            //formula to find res[i]
            res[i] = sumTotal - (n - i - 1) * num + i * num - sumBelow;
            sumBelow += num;
        }
        return res;
    
    }
    
}
