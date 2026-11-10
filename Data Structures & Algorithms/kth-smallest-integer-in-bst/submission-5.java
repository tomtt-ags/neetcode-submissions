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
    public int kthSmallest(TreeNode root, int k) {
        //traverse the array, left then right then root maintain 
        //counter in an array when that hits k return the root your at. 
        int[] check = new int[2]; 
        check[0] = 0;
        dfs(root, check, k);
        return check[1];  
    }
    public void dfs(TreeNode root, int[] check, int k) {
        if(root == null || check[0] >= k) {
            return; 
        }
        dfs(root.left, check, k); 
        check[0]++; 
        if(check[0] == k) {
            check[1] = root.val; 
            return; 
        }
        dfs(root.right, check, k); 
    }
}
