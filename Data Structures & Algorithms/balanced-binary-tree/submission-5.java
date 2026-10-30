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
    public boolean isBalanced(TreeNode root) {
     //keep track of max difference between nodes at any subtree
     //if greater than 1 return false, other wise return true. 
        int[] max = new int[1]; 
        max[0] = 0; 
        calcLength(root, max); 
        if(max[0] > 1) return false; 
        return true; 
    }
    public int calcLength(TreeNode root, int[] max) {
        if(root == null) {
            return 0; 
        }
        int l = calcLength(root.left, max); 
        int r = calcLength(root.right, max); 
        int a = Math.max(l, r); 
        int b = Math.min(l, r);
        int val = (a-b); 
        if(val > max[0]) {
            max[0] = val; 
        }
        return a + 1; 
    }
}
