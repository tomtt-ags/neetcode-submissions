class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>(); 
        for(int i = 0; i < strs.length; i++){
            if(mp.containsKey(isAnagram(strs[i]))){
                mp.get(isAnagram(strs[i])).add(strs[i]); 
            } else {
                List<String> c = new ArrayList<>(); 
                c.add(strs[i]);
                mp.put(isAnagram(strs[i]), c); 
            }
        }
        List<List<String>> out = new ArrayList<>(mp.values());
        return out;  
    }
    public String isAnagram(String check){
        char[] sort = check.toCharArray(); 
        Arrays.sort(sort); 
        String sorted = new String(sort); 
        return sorted; 
    }
}
