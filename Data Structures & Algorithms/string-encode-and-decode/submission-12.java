class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            str.append(strs.get(i) + "¢"); 
        }
        String s = str.toString(); 
        return s; 
    }

    public List<String> decode(String str) {
        List<String> out = new ArrayList<>();
        int s = 0;  
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '¢'){
                out.add(str.substring(s, i)); 
                s = i+1; 
            }
        }
        return out; 
    }
}
