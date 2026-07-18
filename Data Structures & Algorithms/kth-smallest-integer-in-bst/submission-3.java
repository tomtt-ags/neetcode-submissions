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
        int[] arr = new int[2];
        arr[0] = k;  
        dfs(root, arr); 
        return arr[1];  
    }
    private void dfs(TreeNode node, int[] tmp) {
        if (node == null || tmp[0] == 0) return;

        dfs(node.left, tmp);

        if (tmp[0] == 0) return;   

        tmp[0]--;
        if (tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }

        dfs(node.right, tmp);
    }

}
