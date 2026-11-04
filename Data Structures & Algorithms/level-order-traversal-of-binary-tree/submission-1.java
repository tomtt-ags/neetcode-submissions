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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //just do bfs, add every layer to a list. 
        List<List<Integer>> bfs = new ArrayList<>(); 
        if(root == null) return bfs; 
        //bfs is first in first out, you before you remove a node 
        //you add its children. 
        Queue<TreeNode> q = new ArrayDeque<>(); 
        q.add(root); 
        while(!q.isEmpty()) {
            int size = q.size(); 
            List<Integer> layer = new ArrayList<>(); 
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll(); 
                layer.add(curr.val); 
                if(curr.left!=null) {
                    q.add(curr.left); 
                }
                if(curr.right!=null) {
                    q.add(curr.right); 
                }
            }
            bfs.add(layer); 
        }
        return bfs; 
    }
}
