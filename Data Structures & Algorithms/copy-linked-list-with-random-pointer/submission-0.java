/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mp = new HashMap<>(); 
        Node temp = head; 
        Node dummy = new Node(0); 
        Node curr = dummy; 
        while(temp != null){
            if(temp.random != null && !mp.containsKey(temp.random)){
                Node str = new Node(temp.random.val);
                mp.put(temp.random, str); 
            } else if(temp.random == null){
                temp = temp.next; 
                continue; 
            }
            temp = temp.next; 
        }
        temp = head; 
        while(temp != null){
            if(mp.containsKey(temp) && mp.containsKey(temp.random)){
                curr.next = mp.get(temp); 
                curr = curr.next; 
                curr.random = mp.get(temp.random); 
            } else if(temp.random == null){
                if(mp.containsKey(temp)){
                    curr.next = mp.get(temp); 
                    curr = curr.next; 
                    curr.random = null;
                } else {
                    Node str = new Node(temp.val);
                    curr.next = str; 
                    curr = curr.next; 
                    curr.random = null; 
                }
            } else {
                Node str = new Node(temp.val);
                curr.next = str; 
                curr = curr.next; 
                curr.random = mp.get(temp.random); 
            }
            temp = temp.next; 
        }
        Node outp = dummy.next; 
        dummy = null; 
        return outp; 
    }
}
