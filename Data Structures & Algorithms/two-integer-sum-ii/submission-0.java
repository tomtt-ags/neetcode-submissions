class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] out = new int[2]; 
        int sum1 = 0; 
        int sum2 = numbers.length-1; 
        while(sum1 < sum2){
            if(numbers[sum1] + numbers[sum2] > target){
                sum2--; 
            } else if(numbers[sum1] + numbers[sum2] < target){
                sum1++; 
            } else {
                out[0] = sum1+1; 
                out[1] = sum2+1; 
                return out; 
            }
        }
        return out; 
    }
}
