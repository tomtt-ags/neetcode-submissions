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
    //root is the min for right side and max for left side.
    //as you go left the max becomes root, as you go right 
    //min becomes root. 
    public boolean isValidBST(TreeNode root) {
        int lb = Integer.MIN_VALUE; 
        int ub = Integer.MAX_VALUE; 
        return dfs(root, lb, ub); 
    }
    public boolean dfs(TreeNode root, int lb, int ub) {
        if(root == null) return true; 
        if(root.val > lb && root.val < ub) {
            return dfs(root.left, lb, root.val) &&
            dfs(root.right, root.val, ub); 
        }
        return false; 
    }
}
