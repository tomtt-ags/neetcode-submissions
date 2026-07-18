class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            heap.add(i); 
        }
        while(heap.size() > 1){
            int a = heap.poll(); 
            if(heap.size() == 1){
                int c = heap.poll(); 
                if(a==c){
                    return 0; 
                } else if (a > c){
                    heap.add(a-c); 
                } else {
                    heap.add(c-a); 
                }
                return heap.peek(); 
            }
            int b = heap.poll();
            if(a==b){
                    continue; 
                } else if (a > b){
                    heap.add(a-b); 
                } else {
                    heap.add(b-a); 
                }
        }
        return heap.peek();
        
    }
}
