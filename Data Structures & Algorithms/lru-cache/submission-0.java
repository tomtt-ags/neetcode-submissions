class LRUCache {
    HashMap<Integer, Node> mp;
    int size;
    int s; 
    Node left; 
    Node right;   
    public LRUCache(int capacity) {
        mp = new HashMap<>();
        s = 0;  
        size = capacity;
        left = new Node(0, 0); 
        right = new Node(0, 0); 
        left.next = right; 
        right.prev = left; 
    }
    public void remove(Node p){
        Node temp = p.prev; 
        temp.next = p.next;
        p.next.prev = temp; 
    }
    public void insert(Node n){
        Node temp = right.prev;     
        temp.next = n;
        n.prev = temp;
        n.next = right;
        right.prev = n;
    }
    public int get(int key) {
        
        if(mp.containsKey(key)){
            remove(mp.get(key)); 
            insert(mp.get(key)); 
            return mp.get(key).val; 
        } else {
            return -1; 
        }
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key)); 
            insert(mp.get(key));
            mp.get(key).val = value; 
        } else if(s < size){
            mp.put(key, new Node(value, key)); 
            insert(mp.get(key));
            s++;  
        } else {
            Node lru = left.next;   
            remove(lru);
            mp.remove(lru.key);

            Node node = new Node(value, key);
            mp.put(key, node);
            insert(node);
        }
    }
}
class Node{
    int val; 
    int key; 
    Node prev; 
    Node next; 
    Node(int v, int k){
        val = v; 
        key = k; 
        prev = null; 
        next = null; 
    }
}
