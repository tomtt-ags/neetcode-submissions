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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        ser(root, sb);
        return sb.toString();
    }

    private void ser(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        ser(node.left, sb);
        ser(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        int[] idx = new int[1];
        return deser(parts, idx);
    }

    private TreeNode deser(String[] parts, int[] idx) {
        if (idx[0] >= parts.length) return null;

        String token = parts[idx[0]++];
        if (token.equals("null") || token.isEmpty()) return null;

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deser(parts, idx);
        node.right = deser(parts, idx);
        return node;
    }
}
