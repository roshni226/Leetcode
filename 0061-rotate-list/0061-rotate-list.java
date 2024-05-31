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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null)
        {
            return head;
        }
        ListNode slow=head;//used to break the connection
        ListNode fast=head;//used to connect last node to first node
        int count=0;//size of ll
        while(fast!=null)
        {
            fast=fast.next;
            count++;
        }
        fast=head;
        
        for(int i=0;i<(k%count);i++)
        {
            fast=fast.next;
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        if(k==count)//no rotations required if k= size of ll
        {
            return head;
        }
        
        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }
}