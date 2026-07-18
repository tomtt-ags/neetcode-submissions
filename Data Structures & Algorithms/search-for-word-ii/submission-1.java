
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) root.addWord(w);

        Set<String> result = new HashSet<>(); // avoid duplicates
        int rows = board.length, cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, Set<String> result) {
        // bounds
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;

        char ch = board[r][c];
        if (ch == '#') return; // already used in this path

        // if trie doesn't have this next char -> dead end
        TrieNode next = node.children.get(ch);
        if (next == null) return;

        // if this completes a word, add it
        if (next.word != null) {
            result.add(next.word);
            // optional optimization: prevent re-adding same word many times
            next.word = null;
        }

        // mark visited
        board[r][c] = '#';

        dfs(board, r + 1, c, next, result);
        dfs(board, r - 1, c, next, result);
        dfs(board, r, c + 1, next, result);
        dfs(board, r, c - 1, next, result);

        // unmark
        board[r][c] = ch;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // store full word at end node

        void addWord(String w) {
            TrieNode cur = this;
            for (char ch : w.toCharArray()) {
                cur.children.putIfAbsent(ch, new TrieNode());
                cur = cur.children.get(ch);
            }
            cur.word = w;
        }
    }
}

