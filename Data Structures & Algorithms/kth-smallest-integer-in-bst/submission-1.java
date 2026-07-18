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
    int acc = 1; 
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1]; 
        dfs(root, k, arr); 
        return arr[0];  
    }
    public void dfs(TreeNode root, int k, int[] arr){
        if(root == null) return; 
        dfs(root.left, k, arr); 
        if(k == acc) arr[0] = root.val; 
        acc++; 
        dfs(root.right, k, arr); 
    }
}
