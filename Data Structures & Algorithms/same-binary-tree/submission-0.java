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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] check = new boolean[1]; 
        check[0] = true; 
        dfs(p, q, check); 
        return check[0]; 
    }
    public void dfs(TreeNode root, TreeNode root2, boolean[] arr){
        if(root == null && root2 != null){
            arr[0] = false; 
            return; 
        }
        if(root != null && root2 == null){
            arr[0] = false; 
            return; 
        }
        if(root == null && root2 == null){
            return; 
        }
        dfs(root.left, root2.left, arr); 
        if(root.val != root2.val){
            arr[0] = false; 
        }
        dfs(root.right, root2.right, arr); 
    }
}
