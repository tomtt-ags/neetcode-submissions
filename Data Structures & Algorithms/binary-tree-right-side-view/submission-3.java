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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if(root == null) return out;  
        Queue<TreeNode> q = new ArrayDeque<>(); 
        q.add(root); 
        while(!q.isEmpty()){
            int level = q.size();  
            int count = 0; 
            for(int i = 0; i < level; i++){
                TreeNode curr = q.poll();
                //System.out.println(curr.val); 
                if(i == 0) out.add(curr.val); 
                if(curr.right != null) q.add(curr.right); 
                if(curr.left != null) q.add(curr.left);
                //count++; 
            }
        }
        return out; 
    }
}
