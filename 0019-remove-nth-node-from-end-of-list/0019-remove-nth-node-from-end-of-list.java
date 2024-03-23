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
        if(head == null || head.next== null)
        {
            return null;
        }
        int size=0;
        ListNode temp= head;
        while(temp!=null)
        {
            temp = temp.next;
            size++;
        }
        if(n == size)// nth node from the from the end is head so we cant return head
        {
            return head.next;
        }
        ListNode prev= head;
        int index= size-n;
        int i=1;
        while(i<index)
        {
            prev=prev.next;
            i++;
        }
        
        prev.next= prev.next.next;
        return head;
    }
}