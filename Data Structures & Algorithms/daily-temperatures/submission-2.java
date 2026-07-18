class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //you want to loop through temperatures
        //Your stack stores indexes, 
        //Stack<Integer> st = new Stack<>(); 
        int[] compare = new int[2]; 
        int[] res = new int[temperatures.length]; 
        compare[0] = temperatures[0]; 
        compare[1] = 0;
        res[temperatures.length - 1] = 0;  
        for(int i = 1; i < temperatures.length; i++){
            if(i == temperatures.length - 1 && compare[0] >= temperatures[i]){
                    res[compare[1]] = 0; 
                    compare[1] = compare[1] + 1;
                    i = compare[1];  
                    compare[0] = temperatures[compare[1]]; 
                }
            if(compare[1] < temperatures.length - 1 && temperatures[i]>compare[0]){
                res[compare[1]] = i - compare[1];
                compare[1] = compare[1] + 1; 
                i = compare[1]; 
                compare[0] = temperatures[compare[1]]; 
            }
        }
        return res;
    }
}
