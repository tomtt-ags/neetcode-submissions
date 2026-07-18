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
    //you want to find the root of the smallest subtree 
    //that contains both p and q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root; 
        }
        if(root.val > Math.max(p.val, q.val)){
            return lowestCommonAncestor(root.left, p , q); 
        } 
        if(root.val < Math.min(q.val, p.val)){
            return lowestCommonAncestor(root.right, p , q); 
        }
        return root; 
    }
}
