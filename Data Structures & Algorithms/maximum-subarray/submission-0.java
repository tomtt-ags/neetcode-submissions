class Solution {
    public int maxSubArray(int[] arr) {
        //iterate through array, sum of subarray is going to 
        //be current + prev, if curr is greater than sum pick 
        //curr
        int res = arr[0]; 
        int curr = arr[0]; 
        for(int i = 1; i < arr.length; i++){
            curr = Math.max(arr[i], arr[i]+curr);
            res = Math.max(curr, res);
        }
        return res; 
    }
}
