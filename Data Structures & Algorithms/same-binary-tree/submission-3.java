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
        // you need to recursively check if the left subtree == right subtree
        //if both nodes null return true, if ones pop one null return false, if
        //val dont match return false, if they do keep recursing. 
        if(p == null && q == null) return true; 
        if(p == null && q != null) return false; 
        if(p != null && q == null) return false; 
        if(p.val != q.val){
            return false; 
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    
    }
}
