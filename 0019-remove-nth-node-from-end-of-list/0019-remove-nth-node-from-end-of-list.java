/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=1;
        ListNode temp = head;
        while(temp.next!=null)
        {
            temp=temp.next;
            size++;
        }
        if(size==n)
        {
            return head.next;
        }
        int previndex= size-n;
        temp=head;
        while(previndex!=1)
        {
            temp=temp.next;
            previndex--;
        }
        
        temp.next=temp.next.next;
        return head;
        
    }
}