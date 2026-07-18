class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> out = new ArrayList<>();
        List<String> res = new ArrayList<>();  
        dfs(0, s, out, res); 
        return out; 
    }
    public void dfs(int i, String s, List<List<String>> out, List<String> res){
        if(i == s.length()){
            ArrayList<String> copy = new ArrayList<>(res); 
            out.add(copy); 
            return; 
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if(isPalindrome(s.substring(i, j))){
                res.add(s.substring(i, j)); 
                dfs(j, s, out, res); 
                res.remove(res.size() - 1);
            }
        }

    }
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
