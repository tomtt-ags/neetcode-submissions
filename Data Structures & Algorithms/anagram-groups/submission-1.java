class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>(); 
        HashMap<String, List<String>> mp = new HashMap<>(); 
        for(int i = 0; i < strs.length; i++){
            char[] curr = strs[i].toCharArray(); 
            Arrays.sort(curr);
            String a = new String(curr); 
            if(mp.containsKey(a)){
                mp.get(a).add(strs[i]); 
            } else {
                mp.put(a, new ArrayList<String>()); 
                mp.get(a).add(strs[i]); 
            }
        }
        for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
            out.add(entry.getValue()); 
        }
        return out; 
    }
}
