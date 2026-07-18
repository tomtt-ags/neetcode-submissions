class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //create a helper method where we do binary search on each element
        //loop through 2D matrix s.t. we pass each array into this helper method
        //if it returns true at anypoint just return true altogether
        //if it leaves then return false. 
        //this sol is mlog(n).
        for(int i = 0; i < matrix.length; i++){
            if(binarySearch(matrix[i], target)) return true; 
        }
        return false; 
    }
    public boolean binarySearch(int[] test, int target){
        int l = 0; 
        int r = test.length-1; 
        while(l <= r){
            int mid = (l+r)/2; 
            if(target>test[mid]){
                l = mid + 1; 
            }else if(target < test[mid]){
                r = mid-1; 
            }else{
                return true; 
            }
        }
        return false; 
    }
}
