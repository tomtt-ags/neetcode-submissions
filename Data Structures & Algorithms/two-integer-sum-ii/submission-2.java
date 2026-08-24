class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //two pointers l and r, find sum of l + r, if too big then 
        //move r down, if too small move l up. 
        int l = 0; 
        int r = numbers.length - 1; 
        int[] out = new int[2]; 
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                out[0] = l+1; 
                out[1] = r+1; 
                return out; 
            } else if (sum > target){
                r--; 
            } else {
                l++; 
            }
        }
        return out; 
    }
}
