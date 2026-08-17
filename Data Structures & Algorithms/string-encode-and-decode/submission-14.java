class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            str.append(Integer.toString(strs.get(i).length())
             + "#" + strs.get(i)); 
        }
        String s = str.toString(); 
        return s; 
    }
    int n = 0; 
    public List<String> decode(String str) {
        List<String> out = new ArrayList<>(); 
        int l = 0; 
        while(l < str.length())
        {
            if(str.charAt(l) == '#'){
                String itg = str.substring(n, l); 
                int skip = Integer.parseInt(itg); 
                out.add(str.substring(l+1, l+1+skip));
                l = l+1+skip;
                n = l;  
                continue; 
            }
            l++; 
        } 
        return out; 
    }
}
