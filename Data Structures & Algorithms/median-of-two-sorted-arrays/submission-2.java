class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int check = nums1.length + nums2.length; 
        int l1 = 0; 
        int r1 = nums1.length; 
        int l2 = 0; 
        int r2 = nums2.length;
        int mid1 = (l1 + r1)/2;
        int mid2 = (l2 + r2)/2;
        if(nums1.length == 0 && nums2.length == 0) return 0; 
        if(nums1.length == 0){
            if(nums2.length % 2 == 1){
                return nums2[mid2]; 
            }else{
                return ((double)nums2[mid2] + (double)nums2[mid2-1])/2; 
            }
        }
        if(nums2.length == 0){
            if(nums1.length % 2 == 1){
                return nums1[mid1]; 
            }else{
                return ((double)nums1[mid1] + (double)nums1[mid1-1])/2; 
            }
        }
        if(check % 2 == 1){
            while(nums1.length - 1 > mid1 && nums2[mid2] > nums1[mid1+1]){
                mid2--; 
                mid1++; 
                if(mid2 < 0) return nums1[mid1]; 
            }
            while(nums2.length - 1 > mid2 && nums1[mid1] > nums2[mid2+1]){
                mid2++; 
                mid1--;
                if(mid1 < 0) return nums2[mid2];  
            }
            return Math.min(nums1[mid1], nums2[mid2]);
        } else {
            while(nums1.length - 1 > mid1 && nums2[mid2] > nums1[mid1+1]){
                mid2--; 
                mid1++; 
                if(mid2 < 0) return ((double)nums1[mid1] + (double)nums1[mid1-1])/2; 
            }
            while(nums2.length - 1 > mid2 && nums1[mid1] > nums2[mid2++]){
                mid2++; 
                mid1--;
                if(mid1 < 0) return ((double)nums2[mid2] + (double)nums2[mid2-1])/2;  
            }
            if(nums1[mid1] == nums2[mid2]){
                int var2 = Math.min(nums1[mid1-1], nums2[mid2-1]);
                return ((double)nums1[mid1] + (double)var2)/2; 
            }
            int mid = Math.min(nums1[mid1], nums2[mid2]);
            if(mid == nums1[mid1]){
                return ((double)nums1[mid1] + (double)nums2[mid2-1])/2; 
            } else {
                return ((double)nums2[mid2] + (double)nums1[mid1-1])/2; 
            }
        }
    }
}
