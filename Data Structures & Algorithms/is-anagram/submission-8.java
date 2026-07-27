class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer>set = new HashMap<>(); 
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            if(set.containsKey(s.charAt(i))){
                int curr = set.get(s.charAt(i));
                set.replace(s.charAt(i), ++curr); 
            } else {
                set.put(s.charAt(i), 1);
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(!set.containsKey(t.charAt(i))){
                return false;
            } else{
              int curr = set.get(t.charAt(i)); 
              set.replace(t.charAt(i), --curr);  
            }
        }
        ArrayList<Integer> check = new ArrayList<>(set.values());

        for(int i = 0; i < check.size(); i++){
            if(check.get(i) != 0) return false; 
        }
        return true; 
    }
}
