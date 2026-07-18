class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        if(strs.size()==0) return null; 
        sb.append(strs.get(0)+"|"); 
        for(int i = 1; i < strs.size(); i++){
            sb.append(strs.get(i) + "|"); 
        }
        String out = sb.toString(); 
        return out; 
    }

    public List<String> decode(String str) { 
        List<String> out = new ArrayList<>();
        if(str == null) return out; 
        int start = 0; 
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '|'){
                out.add(str.substring(start, i)); 
                start = i+1; 
            }
        }
        //out.add(str.substring(start, str.length())); 
        return out; 
    }
}
