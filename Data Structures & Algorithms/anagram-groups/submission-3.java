class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //hashmap with a unique key, that stores arraylists at each key
        //if a word matches with the key you put it into that array list 
        HashMap<String, ArrayList<String>> mp = new HashMap<>(); 
        for(String s : strs){
            String key = getKey(s); 
            if(mp.containsKey(key)){
                mp.get(key).add(s); 
            } else {
                mp.put(key, new ArrayList<String>()); 
                mp.get(key).add(s); 
            }
        }
        return new ArrayList<>(mp.values()); 
    }
    public String getKey(String s){
        int[] freq = new int[26]; 
        for(char c : s.toCharArray()){
            freq[c - 'a']++; 
        }
        StringBuilder sb = new StringBuilder(""); 
        for(int i : freq){
            sb.append(i).append("#"); 
        }
        return sb.toString(); 
    }
}
