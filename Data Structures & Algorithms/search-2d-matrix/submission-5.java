class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //carry out binary search on indexes of my matrix
        //for each index check if target is within range of said index
        //if it is take that array and do binary search on it 
        //return whatever that returns
        //otherwise check is your value too small out of range or too big out 
        //of range and proceed. 
        int l = 0; 
        int r = matrix.length-1; 
        while(l <= r) {
            int mid = (l+r)/2; 
            //check the range
            System.out.println(mid); 
            int length = matrix[mid].length; 
            System.out.println(length);
            if(target >= matrix[mid][0] && target <= matrix[mid][length-1]){
                return binarySearch(matrix[mid], target); 
            } else if (target < matrix[mid][0]) {
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return false; 
    }
    public boolean binarySearch(int[] arr, int targ) {
        int l = 0; 
        int r = arr.length-1; 
        while(l <= r) {
            int m = (l+r)/2; 
            if(arr[m] == targ) {
                return true; 
            } else if(arr[m] < targ) {
                l = m+1; 
            } else {
                r = m-1; 
            }
        }
        return false;  
    }
}
