class Solution {
    public int trap(int[] height) {
        int l = 0; 
        int r = height.length-1; 
        int maxLeft = height[l]; 
        int maxRight = height[r]; 
        int res = 0; 
        while(l<r) {
            if(maxLeft < maxRight) {
                l++; 
                //if this is the case then for this current 
                //index of l there exists a value to the right 
                //bigger than this ones current maxL hence 
                //minimum of maximums will be the maxL we have 
                //encountered.
                maxLeft = Math.max(maxLeft, height[l]);
                res += maxLeft - height[l];
            }
            else {
                r--; 
                //maxleft bigger than maxright, so for our value
                //on the right that index r has maxRight as 
                //its min of maximums as we know a left exist thats
                //bigger and we knwo FOR THAT index maxright is 
                //biggest to right. 
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
            }
        }
        return res; 
    }
}
