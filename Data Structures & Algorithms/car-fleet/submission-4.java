class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[position.length]; 
        int[] dist = new int[position.length];
        ArrayList<Pair> arr = new ArrayList<>();  
        for(int i = 0; i < position.length; i++){
            dist[i] = target - position[i]; 
            time[i] = (double)dist[i]/speed[i]; 
            Pair p = new Pair(dist[i], time[i]); 
            arr.add(p); 
        }
        Stack<Pair> st = new Stack<>(); 
        arr.sort(Comparator.comparingInt((Pair p) -> p.dist).reversed());
        for(int i = 0; i < arr.size(); i++){
            st.push(arr.get(i)); 
        }
        int carF = 0; 
        Pair p = st.pop(); 
        carF++; 
        while(!st.isEmpty()){
            Pair curr = st.pop();
            if(curr.time <= p.time){
                continue; 
            } else {
                carF++; 
                p = curr; 
            }
        }
        return carF; 
    }
}
class Pair{
    int dist; 
    double time; 
    Pair(int dist, double time){
        this.dist = dist; 
        this.time = time; 
    }
}
