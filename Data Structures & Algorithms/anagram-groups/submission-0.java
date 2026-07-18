class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String i : strs){
            char[] chars = i.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

    
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(i);
        }
        return new ArrayList<>(map.values());
    }
}
