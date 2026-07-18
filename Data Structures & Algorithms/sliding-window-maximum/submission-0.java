class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        //we need to find max in each window
        int point = arr[0];
        ArrayList<Integer>out = new ArrayList<Integer>(); 
        for(int i = 0; i < k; i++){
            if(arr[i]>point){
                point = arr[i];
            }
        }
        out.add(point);
        for(int i = k; i < arr.length; i++){
            point = arr[i-k+1];
            for(int j = i-k+1; j <= i; j++){
                if(arr[j]>point){
                point = arr[j];
            }
            }
            out.add(point);
        }
        int[] outp = new int[out.size()];
        for(int i = 0; i < out.size(); i++){
            outp[i] = out.get(i);
        }
        return outp; 
    }
}
