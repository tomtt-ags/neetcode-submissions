class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //you want to take the first array where all el 
        //<= t as p1, then next one as p2, update p2 to be
        //be max of p1 and p2 and continue operation 
        //among rest of list.
        int[] p1 = new int[target.length];  
        boolean c1 = false; 
        int pointer = 0; 
        for(int i = 0; i < triplets.length; i++) {
            if(valid(target, triplets[i])){
                p1 = triplets[i]; 
                c1 = true; 
                break; 
            }
            pointer++; 
        }
        if(c1){
            if(done(target, p1)) return true; 
            pointer+=1; 
            if(pointer >= triplets.length) return false; 
            for(int i = pointer; i < triplets.length; i++){
                if(valid(target, triplets[i])){
                    if(done(target, triplets[i]
                    )) return true; 
                    for(int j = 0; j < triplets[i].length; j++){
                        p1[j] = Math.max(p1[j], triplets[i][j]); 
                    }
                    if(done(target, p1)) return true; 
                }
            }
        }
        return false;
    }
    public boolean done(int[] targ, int[] pi){
        for(int i = 0; i < targ.length; i++) {
            if(targ[i] != pi[i]){
                return false; 
            }
        }
        return true; 
    }
    public boolean valid(int[] targ, int[] pi){
        for(int i = 0; i < targ.length; i++) {
            if(targ[i] < pi[i]){
                return false; 
            }
        }
        return true; 
    }
}
