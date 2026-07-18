class Solution {
    public int longestConsecutive(int[] arr) {
         HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int res = 0;
        int count = 1;
        for(int i = 0; i < arr.length; i++){
            if(!set.contains(arr[i]-1)){
                while(set.contains(arr[i]+count)){
                    count++;
                }
            }
            res = Math.max(res, count);
            count = 1;
        }
return res;
    }
}
