class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //what we want to do is first use binary search to find the correct row to
        //look at then use binary search to find the correct value within the 
        //row.
        //the left pointer should be end of first array, right pointer should be start
        //of last array.
        int l = 0; 
        int r = matrix.length-1;  
        while(l <= r){
            int mid = (l+r)/2; 
            if(target > matrix[mid][matrix[mid].length-1]){
                l = mid+1; 
            } else if(target < matrix[mid][0]){
                r = mid-1; 
            } else {
                return boolSearch(matrix[mid], target); 
            }
        }
        return false;
    }
    public boolean boolSearch(int[] arr, int target){
        int l = 0; 
        int r = arr.length - 1; 
        while(l <= r){
            int mid = (l+r)/2; 
            if(arr[mid]<target){
                l = mid + 1; 
            } else if(arr[mid] > target){
                r = mid - 1; 
            } else {
                return true; 
            }
        }
        return false; 
    }
}
