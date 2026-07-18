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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> out = new ArrayList<>(); 
        dfs(out, root); 
        return out; 
    }
    public void dfs(ArrayList<Integer> out, TreeNode root){
        if(root == null){
            return; 
        }
        dfs(out, root.left); 
        out.add(root.val); 
        dfs(out, root.right); 
    }
}