class Solution {
    public int trap(int[] height) {
        //first and last one aside, for each index amount it can store is
        //take max of left side and right side, find min of those 2
        //amount stored is min - arr[i]. If thats <= 0 then 0 stored. 
        int[] maxLeft = new int[height.length]; 
        int[] maxRight = new int[height.length]; 
        int maxL = height[0]; 
        for(int i = 0; i < height.length; i++){
            maxLeft[i] = maxL; 
            if(height[i]>maxL){
                maxL = height[i]; 
            }
        }
        int max = height[height.length-1]; 
        for(int j = height.length-1; j >= 0; j--){
            maxRight[j] = max; 
            if(height[j]>max){
                max = height[j]; 
            }
        }
        int out = 0; 
        for(int i = 1; i < height.length-1; i++){
            int add = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(add <= 0){
                add = 0; 
            }
            out += add; 
        }
        return out; 
    }
}
