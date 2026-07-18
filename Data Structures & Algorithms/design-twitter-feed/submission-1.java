class Twitter {
    int time; 
    HashMap<Integer, HashSet<Integer>> mp1;
    HashMap<Integer, ArrayList<int[]>> mp2; 
    public Twitter() {
        time = 0; 
        mp1 = new HashMap<>(); 
        mp2 = new HashMap<>(); 
    }
    
    public void postTweet(int userId, int tweetId) {
        if(mp2.containsKey(userId)){
            mp2.get(userId).add(new int[]{time++, tweetId}); 
        }else{
            mp2.put(userId, new ArrayList<>()); 
            mp2.get(userId).add(new int[]{time++, tweetId}); 
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        ArrayList<Integer> out = new ArrayList<>(); 
        HashSet<Integer> followers = mp1.getOrDefault(userId, new HashSet<>()); 
        if (mp2.containsKey(userId)) {
            for(int i = 0; i < mp2.get(userId).size(); i++){
                pq.offer(mp2.get(userId).get(i)); 
            }
        }
        for(int x : followers){
            if (x == userId) continue;
            if (mp2.containsKey(x)) {
                for(int i = 0; i < mp2.get(x).size(); i++){
                    pq.offer(mp2.get(x).get(i));
                }
            }
        }
        int n = 0; 
        while(n < 10 && !pq.isEmpty()){
            out.add(pq.poll()[1]); 
            n++; 
        }
        return out; 
    }
    
    public void follow(int followerId, int followeeId) {
        if(mp1.containsKey(followerId)){
            mp1.get(followerId).add(followeeId); 
        } else{
            mp1.put(followerId, new HashSet<Integer>()); 
            mp1.get(followerId).add(followeeId); 
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(mp1.containsKey(followerId) && mp1.get(followerId).contains(followeeId)){
            mp1.get(followerId).remove(followeeId);
        }
    }
}