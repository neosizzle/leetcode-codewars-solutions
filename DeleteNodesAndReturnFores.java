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
// /https://leetcode.com/problems/delete-nodes-and-return-forest/
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        
        //convert todelete to hashset for quick indexing
        HashSet<Integer> toDelete = new HashSet<>();
        
        for(int i : to_delete){
            toDelete.add(i);
        }
        
        
        //dfs
        removeNodes(root , toDelete, res);
        
        //add root to res if its not removed
        if(!toDelete.contains(root.val)){
            res.add(root);
        }
        
        return res;
        

    }
    
    public TreeNode removeNodes(TreeNode root, HashSet<Integer>toDelete, List<TreeNode> res){
        //base case
        if(root == null){
            return null;
        }
        
        //traverse left and right child and run recursive function on them
        root.left = removeNodes(root.left , toDelete, res);
        root.right = removeNodes(root.right , toDelete, res);
        
        //if node value is in to delete, pass root pointer to its children / add to res list
        if(toDelete.contains(root.val)){
            //add children to res list if they are not null
            if(root.left != null){
                res.add(root.left);
            }
            if(root.right != null){
                res.add(root.right);
            }
            
            //make the current node null
            return null;
        }
        
        //else, return root node
        return root;
        

    }
}
