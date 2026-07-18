public class PrefixTree {
    TreeNode root; 
    public PrefixTree() {
         root = new TreeNode(); 
    }

    public void insert(String word) {
        TreeNode curr = root; 
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TreeNode()); 
            }
            curr = curr.children.get(c); 
        }
        curr.word = true; 
    }

    public boolean search(String word) {
        TreeNode curr = root; 
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false; 
            }
            curr = curr.children.get(c); 
        }
        return curr.word; 
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root; 
        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false; 
            }
            curr = curr.children.get(c); 
        }
        return true; 
    }
}
public class TreeNode{
    boolean word; 
    HashMap<Character, TreeNode> children = new HashMap<>(); 
}
