/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// /https://leetcode.com/problems/path-sum/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        //create a hashset to store the sums 
        HashSet<Integer> sums = new HashSet<>();
        
        //do a dfs and return its sum in the hashset
        dfs(root,sums,0);
        
        //if the hashset contains targetSum, retrun true, else fallse
        return sums.contains(targetSum);
        
    }
    
    public void dfs (TreeNode root , HashSet<Integer> sums, int sum){
        //exit case, null node reached
        if(root == null){
            return;
        }
        
        
        //exit case, leaf node reached
        if(root.left == null & root.right == null){
            sum += root.val;
            sums.add(sum);
            return;
        }
        
        //recursive call
        dfs(root.left , sums , sum += root.val);
        dfs(root.right , sums , sum);
        
        
    }
}
