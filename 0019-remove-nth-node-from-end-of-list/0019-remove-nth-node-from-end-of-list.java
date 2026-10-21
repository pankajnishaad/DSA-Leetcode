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
        ListNode curr=head;
        int count=0;
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
        int idx=count-n;
        if(idx==0) return head.next;
        curr=head;
        for(int i=0; i<idx-1; i++)   //dekho count=5, n=2 hai to idx=3 to mujhe i=2 i.e node 3 par ruk jana hai
        {
            curr=curr.next;
        }
        //jaise loop ruka 
        curr.next=curr.next.next;
        return head;
    }
}