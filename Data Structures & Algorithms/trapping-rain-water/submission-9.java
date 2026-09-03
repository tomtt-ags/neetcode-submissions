class Solution {
    public int trap(int[] height) {
        int[]lMax = new int[height.length]; 
        int[]rMax = new int[height.length]; 
        lMax[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            if(height[i]>lMax[i-1]){
                lMax[i] = height[i]; 
            } else {
                lMax[i] = lMax[i-1];
            }
        }
        rMax[height.length-1] = height[height.length-1]; 
        for(int i = height.length - 2; i >= 0; i--) {
            if(height[i] > rMax[i+1]) {
                rMax[i] = height[i]; 
            } else {
                rMax[i] = rMax[i+1]; 
            }
        }
        int water = 0; 
        for(int i = 0; i < height.length; i++) {
            int curr = Math.min(lMax[i], rMax[i])-height[i]; 
            if(curr <= 0) continue; 
            water += curr; 
        }
        return water; 
    }
}
