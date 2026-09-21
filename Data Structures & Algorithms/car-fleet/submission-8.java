class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Pair> st = new Stack<>(); 
        ArrayList<Pair> pairs = new ArrayList<>(); 
        for(int i = 0; i < position.length; i++) {
            Pair p = new Pair(); 
            p.x = position[i]; 
            p.y = (double)(target - position[i])/speed[i]; 
            pairs.add(p); 
        }
        pairs.sort((a, b) -> 
        Integer.compare(b.x, a.x));
        for(int i = 0; i < pairs.size(); i++) {
            Pair p = pairs.get(i);
            if(st.isEmpty() || st.peek().y < p.y) {
                st.push(p); 
            }  
        }
        return st.size(); 
    }
}
class Pair{
    int x; 
    double y; 
}
