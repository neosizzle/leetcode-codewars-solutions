//https://leetcode.com/problems/combination-sum/
class Solution {
    /*
    Entry point
    
    1. Checks for invalid candidates
    2. call helper
    3. return result
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return (res);
        solve(res, new ArrayList<>(), candidates, 0, target);
        return (res);
    }
    
    /*
    Recursive function , simulates taking and not taking current index
    
    1. Checks for base case where remainder is 0 (we reached target)
        - if yes, add to res and return
    2. For each number in our candidates starting from index, add it into temp
        array list
    3. Recurse with updated parameters and minus remainder (taking current number)
    4. Remove the last element in arraylist (removing number)
    
    @param List<List<Integer>> res  The result arraylist
    @param List<Integer> temp       The temp arraylist
    @param int[] candidates         The candidates
    @param int index                The current index
    @param int remain               The remainder of nums to sum
    @return void
    */
    public void solve(List<List<Integer>> res, List<Integer> temp, int[] candidates, int index, int remain)
    {
        int i;
        
        if (remain == 0)
        {
            res.add(new ArrayList(temp));
            return ;
        }
        i = index - 1;
        while (++i < candidates.length)
        {
            if (candidates[i] <= remain)
            {
                temp.add(candidates[i]);
                solve(res, temp, candidates, i , remain - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
