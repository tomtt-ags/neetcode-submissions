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

    int best = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return best;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int[] arr = new int[6];
        arr[0] = root.val;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        arr[1] = Integer.MIN_VALUE;      // <-- key fix
        arr[2] = left + arr[0];
        arr[3] = Integer.MIN_VALUE;      // <-- key fix
        arr[4] = right + arr[0];
        arr[5] = left + right + arr[0];

        best = Math.max(best, maxArr(arr));

        return arr[0] + Math.max(left, right);
    }

    public int maxArr(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > max) max = x;
        }
        return max;
    }
}
