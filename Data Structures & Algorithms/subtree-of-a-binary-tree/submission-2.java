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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //we need to include the whole on subroot in root. 
        //if they are the same root you want to recurse 
        boolean[] out = new boolean[1]; 
        out[0] = false; 
        dfs(root, subRoot, out); 
        return out[0]; 
    }
    public void dfs(TreeNode r1, TreeNode r2, boolean[] out){
        if(r1 == null) return; 
        if(r1.val == r2.val) {
            out[0] = isSameTree(r1, r2, out); 
        }
        if(out[0] == false){
            dfs(r1.left, r2, out); 
            dfs(r1.right, r2, out); 
        } else {
            return; 
        }
    }
    public boolean isSameTree(TreeNode r1, TreeNode r2, boolean[] out) {
        if(r1 == null && r2 == null) return true; 
        if(r1 == null || r2 == null) return false; 
        if(r1.val != r2.val) {
            return false; 
        } else {
            return isSameTree(r1.left, r2.left, out) && isSameTree(r1.right, r2.right, out);
        }
    }
}
