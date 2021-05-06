//https://leetcode.com/problems/binary-tree-level-order-traversal/
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
class Solution {
    
    //the result is a list of lists
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //error checkung
        if(root == null){
            return result;
        }
        
        //add root node into queue
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        
        //while queue is not empty / there are still nodes in the tree
        while(!nodeQueue.isEmpty()){
            
            //current queue size is the current size of the level
            int size = nodeQueue.size();
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();
            
            //remove nodes from queue and add it to result according to current size
            for(int i = 0 ; i < size; ++i){
                TreeNode current = nodeQueue.remove();
                
                currentLevel.add(current.val);
                
                if(current.left != null){
                    nodeQueue.add(current.left);
                }
                
                if(current.right != null){
                    nodeQueue.add(current.right);
                }
            }
            
            result.add(currentLevel);
            
            
        }
        
        return result;
        
    }
}
