class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        if(strs.size()==0) return null; 
        int el = strs.get(0).length(); 
        sb.append(Integer.toString(el)+"|"+strs.get(0)); 
        for(int i = 1; i < strs.size(); i++){
            sb.append(Integer.toString(strs.get(i).length())+ "|" + strs.get(i)); 
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
                int n = Integer.parseInt(str.substring(start, i)); 
                out.add(str.substring(i+1, i+1+n)); 
                i = i + n + 1; 
                start = i; 
            }
        }
        //out.add(str.substring(start, str.length())); 
        return out; 
    }
}
