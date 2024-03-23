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
    public ListNode findMid(ListNode head)
    {
        ListNode slow= head;
        ListNode fast= head;
        
        while(fast.next != null && fast.next.next != null)// 
        {
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null)
        {
            ListNode front= cur.next;
            cur.next=prev;
            prev=cur;
            cur=front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
    
        //Edge cases
        if(head==null || head.next==null)
        {
            return true;
        }
        
        //Find Middle of the list
        ListNode middle= findMid(head);
        
        //Reverse middle of the list
        ListNode secondH = reverse(middle.next);
        
        //Compare first and second half
        ListNode firstH= head;
        while(secondH !=null)
        {
            if(firstH.val != secondH.val)
            {
                return false;
            }
            secondH=secondH.next;
            firstH=firstH.next;
        }
        return true;
    }
}