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
    public int maxDepth(TreeNode root) {
        int count = depth(root, 0); 
        return count; 
    }
    public int depth(TreeNode head, int c){
        if(head == null){
            return c; 
        }
        int a = depth(head.left, c+1); 
        int b = depth(head.right, c+1);
        return Math.max(a, b); 
    }
}
