class MedianFinder {
    PriorityQueue<Integer> rightHalf; 
    PriorityQueue<Integer> leftHalf;
    public MedianFinder() {
        rightHalf = new PriorityQueue<>(); 
        leftHalf = new PriorityQueue<>(Collections.reverseOrder()); 
    }
    
    public void addNum(int num) {
        leftHalf.offer(num); 
        if(!rightHalf.isEmpty() && num > rightHalf.peek()){
            rightHalf.offer(leftHalf.poll()); 
        }
        while(leftHalf.size() - rightHalf.size() > 1){
            rightHalf.offer(leftHalf.poll()); 
        }
        while(rightHalf.size() - leftHalf.size() > 1){
            leftHalf.offer(rightHalf.poll()); 
        }
    }
    
    public double findMedian() {
        //you have to maintain two heaps, one being a max heap 
        //with smaller values
        //other being min heap with larger values
        //next thing is size they should have at most a size difference 
        //of 1 apart if it exceeds this then take top of heap with
        //more elements and put it in the other one. 
        //if sizes == each other then median is sum of both peaks over two 
        //other wise median is peak of bigger heap. 
        if(leftHalf.size() == rightHalf.size()){
            return ((double) leftHalf.peek() + (double) rightHalf.peek())/2.0; 
        } else if (leftHalf.size() > rightHalf.size()){
            return (double)leftHalf.peek(); 
        } else {
            return (double)rightHalf.peek(); 
        }
    }
}
