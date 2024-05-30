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
    public ListNode getKNode(ListNode temp, int k)
    {
        while((k-1)!=0 && temp!=null)
        {
            temp=temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverseList(ListNode head)
    {
        ListNode curr=head,prev=null,front;
        while(curr!=null)
        {
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode temp=head;
        ListNode prevLast= dummy;
        ListNode nextNode, KNode;
        
        while(temp!=null)
        {
            KNode=getKNode(temp,k);
            if(KNode==null)
            {
                prevLast.next=temp;
                break;
            }
            
            nextNode= KNode.next;
            KNode.next=null;
            //reverse in groups of k
            ListNode newHead= reverseList(temp);
            
            prevLast.next=newHead;
            prevLast=temp;
            temp=nextNode;
            
            
        }
        return dummy.next;
    }
}