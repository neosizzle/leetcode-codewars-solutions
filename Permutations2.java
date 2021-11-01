//https://leetcode.com/problems/permutations-ii/submissions/

class Solution {
    /*
    ** Shell function
    ** 
    ** 1. checks for errors
    ** 2. sorts the nums array
    ** 3. calls helper and returns res
    */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        solve(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }
    
    /*
    ** Helper func
    ** 
    ** 1. check for base case where current generated list is == to the length of nums
    **     - if it hits, add to result and return
    ** 2. Iterate through nums
    ** - If current index is visited by parent, continue
    ** - If the current value is same as the value at curr index - 1 and the prev value is not visited, continue (dupe repeat)
    ** - If not, set it to visited and recurse after adding current value to current generated list
    ** - Remove latest value from current and set visited to false
    **
    */
    public void solve(int []nums, List<Integer> current, List<List<Integer>> res, boolean[] visited)
    {
        if (current.size() == nums.length)
        {
            res.add(new ArrayList(current));
            return ;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (visited[i] == true)
                continue ;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            current.add(nums[i]);
            visited[i] = true;
            solve(nums, current, res, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
