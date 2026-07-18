class Solution {
    //you just want to find a window of the same size 
    //as s1 that contains the same letters 
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp = new HashMap<>(); 
        char[] s2arr = s2.toCharArray();
        char[] s1arr = s1.toCharArray();
        int total = 0; 
        for(char i : s1arr){
            mp.put(i, mp.getOrDefault(i, 0)+1); 
            //total += i; 
        } 
        //System.out.println(total); 
        int l = 0; 
        //int temp = total; 
        for(int r = 0; r < s2arr.length; r++){
            if(!mp.containsKey(s2arr[r])){
                l++;
            }
            int length = r-l+1;
            //System.out.println(l);  
            //System.out.println(length);  
            if(length == s1.length()){
                int p = 0;
                char[] check = new char[s1arr.length];
                while(l <= r){
                    //temp -= s2arr[l];
                    //System.out.println(temp);
                    check[p] = s2arr[l];
                    p++;  
                    l++;
                }
                if(arrCheck(s1arr, check)){
                    return true; 
                } else {
                    l = r - length + 2; 
                    //temp = total; 
                }
            }
            //System.out.println(l);
        }
        return false; 
    }
    public boolean arrCheck(char[] a1, char[] a2){
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char i : a1){
            //System.out.println(i); 
            mp.put(i, mp.getOrDefault(i, 0)+1); 
        } 
        for(char i : a2){
            System.out.println(i); 
            if(mp.containsKey(i)){
                mp.put(i, mp.get(i)-1);
            } 
        }
        for(Map.Entry<Character, Integer> e : mp.entrySet()){
            System.out.println(e.getValue()); 
            if(e.getValue()>0)return false; 
        }
        return true; 
    }
}
