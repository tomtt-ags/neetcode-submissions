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
//we know how to get height of left and right, - them and its true 
//long as difference is always 1.
class Solution {
    boolean outPut = true; 
    public boolean isBalanced(TreeNode root) {
        int n = checkBalance(root); 
        return outPut; 
    }
    public int checkBalance(TreeNode root){
        if(root == null){
            return 0; 
        }
        int left = checkBalance(root.left); 
        int right = checkBalance(root.right);
        if(Math.abs(left - right) > 1) outPut = false; 
        return 1 + Math.max(left, right);  
    }
}
