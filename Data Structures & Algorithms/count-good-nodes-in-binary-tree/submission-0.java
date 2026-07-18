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
    public int goodNodes(TreeNode root) {
        //recurse down, and have an extra parameter that will 
        //be the biggest node to date
        int[] out = new int[1]; 
        dfs(root, root.val, out); 
        return out[0]; 
    }
    public void dfs(TreeNode root, int great, int[] arr){
        if(root == null) return; 
        if(root.val >= great){
            arr[0]++; 
            great = root.val;
        }
        dfs(root.left, great, arr); 
        dfs(root.right, great, arr);
    }
}
