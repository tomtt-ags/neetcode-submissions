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
    int res = Integer.MIN_VALUE; 
    public int diameterOfBinaryTree(TreeNode root) {
        int n = depth(root); 
        return res; 
    }
    public int depth(TreeNode root){
        //find height of left, height of right add them, return
        //max height + 1. 
        if(root == null) return 0;
        int left = depth(root.left); 
        int right = depth(root.right); 
        int diameter = left + right; 
        res = Math.max(res, diameter); 
        return 1 + Math.max(left, right); 
    }
}
