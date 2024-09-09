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
    public ListNode middleNode(ListNode head) {
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        ListNode slow= head;
        ListNode fast= head;
        while( fast.next!=null && fast.next.next !=null)
        {
            fast= fast.next.next;
            slow=slow.next;
        }
        return (size%2==0)?slow.next:slow;
        
    }
}