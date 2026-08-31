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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list=new ArrayList<>();
        int idx=1;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr.next!=null)
        {
            ListNode next=curr.next;
            boolean isMaxima= curr.val>prev.val && curr.val>next.val;
            boolean isMinima=curr.val<prev.val && curr.val<next.val;
            if(isMaxima || isMinima)
            {
                list.add(idx);
            }
            prev=curr;
            curr=next;
            idx++;
        }
        if(list.size()<2)
        {
            return new int[]{-1, -1};
        }
        int minDis=Integer.MAX_VALUE;
        for(int i=1; i<list.size(); i++)
        {
            int dis=list.get(i)-list.get(i-1);
            minDis=Math.min(dis, minDis);
        }
        // int maxDis=list.get(list.size()-1)-list.get(0);
           int maxDis=list.get(list.size()-1)-list.get(0);
        return new int[]{minDis, maxDis};
    }
}