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
    public ListNode findMiddle(ListNode head)
    {
        //using fast and slow pointer approach
        ListNode slow= head;
        ListNode fast= head;
        
        while(fast.next != null && fast.next.next!=null)
        {
            fast= fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr= head;
        ListNode front;
        
        while(curr!=null)
        {
            front= curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        
        ListNode middle = findMiddle(head);
        ListNode head2 = reverse(middle.next);
        
        while(head2!= null)
        {
            if(head2.val != head.val)
            {
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;
        
    }
}