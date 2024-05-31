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
        if(k==0||head==null||head.next==null)
        {
            return head;
        }
        ListNode temp=head;//used to break the connection
        ListNode end=head;//used to connect last node to first node
        int count=1;//size of ll
        while(temp.next!=null)
        {
            temp=temp.next;
            count++;
        }
        if(k%count==0) return head;
        temp.next=head;          
        for(int i=0;i<k%count;k++)
        {
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
}