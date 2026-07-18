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
        boolean[] arr = new boolean[1]; 
        arr[0] = false; 
        checkTree(root, subRoot, arr); 
        return arr[0]; 
    }
    public void checkTree(TreeNode root, TreeNode subRoot, boolean[] arr){
        if(root == null){
            return; 
        }
        if(root.val == subRoot.val && arr[0] == false){
            if(checkSubTree(root, subRoot)){
                arr[0] = true; 
            }
        }
        checkTree(root.left, subRoot, arr); 
        checkTree(root.right, subRoot, arr);
    }
    public boolean checkSubTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true; 
        }
        if(root == null || subRoot == null || root.val != subRoot.val){
            return false; 
        }
        return checkSubTree(root.left, subRoot.left) && checkSubTree(root.right, subRoot.right); 
    }
}
