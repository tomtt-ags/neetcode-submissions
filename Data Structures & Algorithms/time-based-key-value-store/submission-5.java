class TimeMap {
    //timeMap is a hashmap that has a key and value which 
    //is a list of pairs. Pair being value + timestamp. 
    //you want to get value that is closest to your specified timestamp
    HashMap<String, ArrayList<Pair>> mp; 
    public TimeMap() {
        //here you just create your hashmap obj.
        mp = new HashMap<>();  
    }
    
    public void set(String key, String value, int timestamp) {
        //here just create a pair and add the pair, value and key 
        //to my hashmap
        Pair p = new Pair(value, timestamp); 
        if(mp.containsKey(key)){
            mp.get(key).add(p); 
        } else {
            ArrayList<Pair> l = new ArrayList<>();
            l.add(p);  
            mp.put(key, l); 
        }
    }
    
    public String get(String key, int timestamp) {
        //here is where my functionality lies, get the value at a 
        //specified timestamp. 
        if(!mp.containsKey(key)) {
            return ""; 
        }
        ArrayList<Pair> curr = mp.get(key); 
        int l = 0;
        int r = curr.size()-1; 
        int out = Integer.MAX_VALUE; 
        while(l <= r) {
            int mid = l + (r-l)/2; 
            if(curr.get(mid).timeStamp > timestamp) {
                r = mid - 1; 
            } else {
                out = mid; 
                l = mid + 1; 
            }
        }
        if(out > timestamp) return ""; 
        return curr.get(out).value; 
    }
}
class Pair {
    String value; 
    int timeStamp; 
    Pair (String v, int x) {
        this.value = v; 
        this.timeStamp = x; 
    }
}
