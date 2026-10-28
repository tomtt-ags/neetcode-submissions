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
    public int diameterOfBinaryTree(TreeNode root) {
       //return the current max and the max depth to the previous node, 
       //node will return max of curr diam, l + r. 
       int[] max = new int[1]; 
       max[0] = 0;
       int x = calcDepth(root, max); 
       return max[0]; 
    }
    public int calcDepth(TreeNode root, int[] max) {
        if(root == null) return 0; 
        int left = calcDepth(root.left, max); 
        int right = calcDepth(root.right, max); 
        max[0] = Math.max(max[0], left + right); 
        return Math.max(left, right) + 1; 
    }

}
