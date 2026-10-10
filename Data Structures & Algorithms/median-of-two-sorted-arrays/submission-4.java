class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //i want to find valid left partition take smaller sized list
        //find n/2 on it then do half - that to find that space on other 
        //list then to check if partition is valid you want to check a criss
        //cross fashion while keeping bounds in mind, if not maintained
        //if value is greater than other side then look its left side
        //recalc the half. 
        int length = nums1.length + nums2.length; 
        int half = length/2; 
        int[] A;
        int[] B;
        if(nums1.length <= nums2.length) {
            A = nums1; 
            B = nums2; 
        } else {
            A = nums2; 
            B = nums1; 
        }
        int m = A.length; 
        int n = B.length; 
        int l = 0;
        int r = A.length; 
        while(l <= r) {
            int i = (l + r) / 2;
            int j = (m + n + 1) / 2 - i;

            int aLeft = (i > 0) ? A[i - 1] 
            : Integer.MIN_VALUE;
            int aRight = (i < A.length) ? A[i]
            : Integer.MAX_VALUE;

            int bLeft = (j > 0) ? B[j - 1] 
            : Integer.MIN_VALUE;
            int bRight = (j < B.length) ? B[j]
            : Integer.MAX_VALUE;            
            if (aLeft <= bRight && bLeft <= aRight) {
                if ((m + n) % 2 == 1) {
                    return Math.max(aLeft, bLeft);
                }
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                r = i - 1; // cut too far right in A
            } else {
                l = i + 1; // cut too far left in A
            }
        }
        return -1; 
    }
}
