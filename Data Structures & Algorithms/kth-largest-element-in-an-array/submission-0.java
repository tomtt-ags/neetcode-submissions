class Solution {
    public int findKthLargest(int[] nums, int k) {
        //just push all elements to a max heap
        //pop the max heap k times and return the kth thing
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int i : nums){
            q.offer(i); 
        }
        int out = 0; 
        while(k > 0){
            out = q.poll(); 
            k--; 
        }
        return out;
    }
}
