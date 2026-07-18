class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>(); 
        HashMap<String, List<String>>map = new HashMap<>(); 
        for(String str : strs){
            String key = getFreq(str);
            if(map.containsKey(key)){
                map.get(key).add(str); 
            } else {
                map.put(key, new ArrayList<String>());
                map.get(key).add(str); 
            }
        }
        return new ArrayList<>(map.values()); 
    }
    public String getFreq(String str){
        int[] freq = new int[26]; 
        for(char c : str.toCharArray()){
            freq[c - 'a']++; 
        }
        StringBuilder sb = new StringBuilder(); 
        for(int count : freq){
            sb.append(count).append('#'); 
        }
        return sb.toString();
    }
}
