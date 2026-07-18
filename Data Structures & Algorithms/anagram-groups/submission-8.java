class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>(); 
        for(int i = 0; i < strs.length; i++){
            if(mp.containsKey(sortString(strs[i]))){
                mp.get(sortString(strs[i])).add(strs[i]); 
            } else {
                ArrayList<String> ch = new ArrayList<>(); 
                ch.add(strs[i]); 
                mp.put(sortString(strs[i]), ch); 
            }
        }
        List<List<String>> out = new ArrayList<>(mp.values());
        return out;
    }
    public String sortString(String s){
        char[] srt = s.toCharArray();  
        Arrays.sort(srt); 
        return new String(srt); 
    }
}
