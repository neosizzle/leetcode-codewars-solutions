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
//https://leetcode.com/problems/binary-tree-right-side-view/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        //declare result variable
        List<Integer> result = new ArrayList<>();
        
        //constraint filtering
        if(root == null){
            return result;
        }
        
        //declare a queue to initiate bfs
        Queue<TreeNode> queue = new LinkedList<>();
        //add root node to queue
        queue.add(root);
        
        //traverse
        while(!queue.isEmpty()){
            //get the current level size
            int size = queue.size();
            
            //traverse said level
            for(int i = 0; i < size; i++){
                //get the current node and remove it from queue
                TreeNode current = queue.remove();
       
                

                //check if its the last node on current level
                if(i == size - 1){
                    //add node val into result
                    result.add(current.val);
                }
            
                //add children to queue
                if(current.left != null){
                    queue.add(current.left);
                }
                
                 if(current.right != null){
                    queue.add(current.right);
                }
                
            }
            

            
        }
        
        
        return result;
        
    }
}
