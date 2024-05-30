/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1= headA;
        ListNode d2= headB;
        if(d1==null || d2==null)
        {
            return null;
        }
        //finding length of both ll
        int l1=0,l2=0;
        while(d1!=null)
        {
            l1++;
            d1=d1.next;
        }
        while(d2!=null)
        {
            l2++;
            d2=d2.next;
        }
        d1=headA;
        d2=headB;
        //finding difference and moving dummy of larger list by the difference
        if(l1>l2)//l1 is larger
        {
            int diff=l1-l2;
            while(diff!=0)
            {
                d1=d1.next;
                diff--;
            }
        }
        else
        {
            int diff=l2-l1;
            while(diff!=0)
            {
                d2=d2.next;
                diff--;
            }
        }
        
        //now start moving the lists simultaneously
        while(d1!=null&&d2!=null)
        {
            if(d1==d2)
            {
                return d1;
            }
            d1=d1.next;
            d2=d2.next;
        }
        return null;
    }
}