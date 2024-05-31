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
        HashMap<Node, Node> map= new HashMap<>();
        Node temp=head;
        // creating hash map
        while(temp!=null)
        {
            Node newNode= new Node(temp.val);
            map.put(temp,newNode);
            temp=temp.next;
        }
        
        temp=head;
        //creating null and random pointer connections of new nodes with their deep copies
        while(temp!=null)
        {
            Node copy= map.get(temp);// getting deep copy(val) corresponding to the org val(key)
            copy.next=map.get(temp.next);
            copy.random= map.get(temp.random);
            temp=temp.next;
        }
        
        return map.get(head);
    }
}