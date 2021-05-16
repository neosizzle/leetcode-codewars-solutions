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
// /https://leetcode.com/problems/path-sum-ii/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        //shell func
        List<List<Integer>> paths = new ArrayList<>();
        
        //call helper
        pathFind(root, targetSum , new ArrayList<Integer>(), paths);
        
        return paths;
        
        
    }
    
    public void pathFind(TreeNode root , int sum, List<Integer> current,List<List<Integer>> paths){
        //base case, root is null
        if(root == null){
            return;
        }
        
        //root is not null, we should add it into our current path list
        current.add(root.val);
        
        //checks if current node is leaf node and is equals to sum
        if(root.val == sum && root.left == null && root.right == null){
            //if yes, we found a correct path
            paths.add(current);
            return;
        }
        
        //we didnt reach the leaf node or we didnt get the sum, keep traversing
        //use new copy of arraylsit so we dont pass the same list around
        //use sum = root.val to ocmpare noed values
        pathFind(root.left, sum - root.val, new ArrayList<Integer>(current), paths);
        pathFind(root.right, sum - root.val, new ArrayList<Integer>(current), paths);
    }
}
