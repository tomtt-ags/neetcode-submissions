class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      //we need an array of times from the position closest down. 
      //push the first value on, then if its bigger add to stack, if its smaller its part of that class 
      //i can calc times but how can i associate it with order of position 
      TreeMap<Integer, Float> key = new TreeMap<>();
      Float targ = (float)target; 
      Stack<Float> st = new Stack<>();  
      for(int i = 0; i < position.length; i++){
        Float a = (float)position[i]; 
        Float b = (float)speed[i];  
        Float time = (targ - a)/b; 
        key.put(position[i], time); 
      }
      st.push(key.get(key.lastKey())); 
      boolean skipFirst = true; 
      for(Map.Entry<Integer, Float> e : key.descendingMap().entrySet()){
        if(skipFirst){
            skipFirst = false; 
            continue; 
        }
        if(e.getValue() > st.peek()){
            st.push(e.getValue()); 
        }
      }
      return st.size(); 
    }
}
