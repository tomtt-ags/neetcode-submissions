class WordDictionary {
    TrieNode root; 
    public WordDictionary() {
        root = new TrieNode(); 
    }

    public void addWord(String word) {
        TrieNode curr = root; 
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode()); 
            }
            curr = curr.children.get(c); 
        }
        curr.word = true; 
    }

    public boolean search(String word) {
        TrieNode curr = root; 
        return dfs(word.toCharArray(), word.length(), 0, curr);
    }
    public boolean dfs(char[] word, int r, int l, TrieNode curr){
        if(l == r){
            return curr.word;
        }
        if(word[l] != '.') {
            if(curr.children.containsKey(word[l])){
                return dfs(word, r, l+1, curr.children.get(word[l])); 
            }
        } else {
            for(Map.Entry<Character, TrieNode> ch : curr.children.entrySet()){
                if (dfs(word, r, l+1, ch.getValue())) return true; 
            }
        }
        return false; 
    }
}
class TrieNode{
    boolean word; 
    HashMap<Character, TrieNode> children = new HashMap<>(); 
}