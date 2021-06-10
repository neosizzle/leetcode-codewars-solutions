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
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
       //create an array to store how many nodes we have visited and the return value
        int[] arr = new int[2];
        
        //helper method
        getKthSmallest(root , arr , k);
        
        return arr[1];
        
        
    }
    
    public void getKthSmallest(TreeNode root,int[] arr, int k){
        //base case
        if(root == null){
            return;
        }
        
        //visit left child
        getKthSmallest(root.left , arr , k);
        
        //after left child returns, increment arr[0] and set arr[1] to result if incremented value == k
        if(++arr[0] == k){
            arr[1] = root.val;
            return;
        }
        
        //visit right child
        getKthSmallest(root.right , arr , k);
        
    }

}
