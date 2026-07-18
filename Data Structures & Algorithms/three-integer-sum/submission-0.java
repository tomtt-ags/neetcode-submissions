class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        HashSet<ArrayList<Integer>> sumCheck = new HashSet<>(); 
        int sum = 0;  
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(j == i) continue; 
                sum = nums[i] + nums[j];
                if(findTarget(sum, nums, i, j)!= Integer.MIN_VALUE){
                      ArrayList<Integer> outt = new ArrayList<>(); 
                      outt.add(nums[i]); 
                      outt.add(nums[j]); 
                      outt.add(findTarget(sum, nums, i, j));
                      Collections.sort(outt);  
                    if(!sumCheck.contains(outt)){
                        out.add(outt); 
                    }
                    sumCheck.add(outt); 
                } 
            }
        }
        return out; 
    }
    public int findTarget(int sum, int[] nums, int ind1, int ind2){
        for(int i = 0; i < nums.length; i++){
            if(i == ind1) continue;
            if(i == ind2) continue; 
            if(sum + nums[i] == 0){
                return nums[i]; 
            }
        }
        return Integer.MIN_VALUE; 
    }
}
