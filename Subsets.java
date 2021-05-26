//https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
       List<List<Integer>> res = new ArrayList<>();
        
        //call helper method
        generateSubsets(nums, 0 , new ArrayList<Integer>() , res);
                
        return res;
        
    }
    
    public void generateSubsets(int[] nums, int index, List<Integer> current,List<List<Integer>> res){
        //add the current list into our result
        res.add(new ArrayList<>(current));
        
        //start traversing the array
        for(int i = index; i < nums.length; ++i){
            
            //add the current number into the current array
            current.add(nums[i]);
            
            //recursive call to add and remove all subsequent numbers
            generateSubsets(nums , i + 1, current , res);
            
            //after the recursive func returns, all the subsequent combinations that starts with nums[i] have been recorded, remove the current number and move on to the next number
           
            current.remove(current.size() - 1);//cant use i because i is always increasing yet the current length is always being changed
            
        }
        
        
    }
}
