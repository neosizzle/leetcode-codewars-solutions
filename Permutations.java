//https://leetcode.com/problems/permutations/
class Solution {
    /*
    Entry point
    */
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return (res);
        solve(res, new ArrayList<>(), nums, nums.length, new boolean[nums.length]);
        return (res);
    }
    
    /*
    Recursive helper
    
    1. Check for base case where the size of temp array is == to the length of nums
        - add to res and return if it hits
    2. Loop through every number starting from the nums array
        - if current index is visited, continue.
        - add the current index in nums to temp
        - recurse and update index
        - remove the last element of temp
    @param List<List<Integer>> res  The result list
    @param List<Integer> temp       The current list
    @param int[] nums               The nums array
    @param int len                  The size of the array to match
    @param boolean visited          Array to keep track of visited indexes
    @return void
    */
    public void solve(List<List<Integer>> res, List<Integer> temp, int[] nums, int len, boolean[] visited)
    {
        int i;
        
        if (temp.size() == len)
        {
            res.add(new ArrayList(temp));
            return ;
        }
        i = -1;
        while (++i < len)
        {
            if (visited[i] == true)
                continue ;
            temp.add(nums[i]);
            visited[i] = true;
            solve(res, temp, nums, len, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
