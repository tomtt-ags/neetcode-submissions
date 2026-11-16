class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //think of it as a graph, if you have to 
        //visit a visited node then its impossible. 
        //pre req are the edges. 
        HashMap<Integer, ArrayList<Integer>> adjList = buildList(numCourses,
        prerequisites); 
        //a cycle is the issue, if present return false, you want to do dfs 
        //on all neighbors, if a neigbor returns false its impossible. a cycle 
        //present if when you recurse you reach a visited node as a prereq so 
        //a pre req is a node you alr visited. 
        HashSet<Integer> visit = new HashSet<>(); 
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, adjList, visit)) {
                return false; 
            }
        }
        return true; 

    }
    public boolean dfs(int src, HashMap<Integer
    , ArrayList<Integer>> ad,  HashSet<Integer>
    visit) {
        ArrayList<Integer> neighbors = ad.get(src); 
        if(visit.contains(src)) return false; 
        if(neighbors.isEmpty()) return true; 
        boolean outp = false; 
        visit.add(src);
        for(int neigbor : neighbors) {
            outp = dfs(neigbor, ad, visit); 
            if(outp == false) return false; 
        }
        visit.remove(src); 
        ad.get(src).clear(); 
        return outp; 
    }
    public HashMap<Integer, ArrayList<Integer>> buildList(int num, int[][] pre){
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>(); 
        for(int[] p : pre) {
            int src = p[0]; 
            int dest = p[1]; 
            if(!mp.containsKey(src)){
                mp.put(src, new ArrayList<Integer>()); 
            }
            if(!mp.containsKey(dest)){
                mp.put(dest, new ArrayList<Integer>()); 
            }
            mp.get(src).add(dest); 
        }
        for(int i = 0; i < num; i++) {
            if(!mp.containsKey(i)){
                mp.put(i, new ArrayList<Integer>()); 
            }
        }
        return mp; 
    }
}
