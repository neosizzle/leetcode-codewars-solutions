//https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        //sort the array to prevent dupes
        Arrays.sort(candidates);
        
        findCombs(candidates , 0, target, new ArrayList<>(), res);
        
        return res;
        
    }
    
    public void findCombs(int[] candidates, int index, int target, List<Integer> current , List<List<Integer>> res){//index specifiesthe current index that we are in
        //base case
        //we found a combination
        if(target == 0){
            res.add(new ArrayList<>(current));
            return;
        }
        
        //the numbers already exceed target, no point continueing 
        if(target < 0){
            return;
        }
        
        //for each number we traverse
        for(int i = index; i < candidates.length; ++i){
            //stimulate picking and removing every number, e.g every single combination
            
            //this constraint makes sure no number is repeated 2 times in a row
            if(i == index || candidates[i] != candidates[i - 1]){
                //stimulate picking the number
                current.add(candidates[i]);
                
                //call recursively to pick other numbers / dfs
                findCombs(candidates , i + 1, target - candidates[i], current , res);
                
                //afet above funcs return, which means all the combinations that start with candidates[i] have been selected and removed, so we can remove the current number
                current.remove(current.size() - 1);
                
            }
            
        }
        
    }
}
