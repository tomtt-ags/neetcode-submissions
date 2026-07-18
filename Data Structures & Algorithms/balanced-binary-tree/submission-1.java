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
    public boolean isBalanced(TreeNode root) {
        boolean[] out = new boolean[1]; 
        out[0] = true; 
        int n = checkBalance(root, out); 
        return out[0]; 
    }
    public int checkBalance(TreeNode root, boolean[] arr){
        if(root == null){
            return 0; 
        }
        int left = checkBalance(root.left, arr); 
        int right = checkBalance(root.right, arr);
        if(Math.abs(left - right) > 1) arr[0] = false; 
        return 1 + Math.max(left, right);  
    }
}
