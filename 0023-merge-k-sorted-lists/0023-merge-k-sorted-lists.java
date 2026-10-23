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
    public ListNode mergeKLists(ListNode[] lists) {
        // List<Integer> values=new ArrayList<>();
        // for(ListNode head: lists)
        // {
        //     while(head!=null)
        //     {
        //         values.add(head.val);
        //         head=head.next;
        //     }
        // }
        // Collections.sort(values);
        // ListNode dummy=new ListNode(0);
        // ListNode curr=dummy;
        // for(int val: values)
        // {
        //     curr.next=new ListNode(val);
        //     curr=curr.next;
        // }
        // return dummy.next;


        //using minheap

        PriorityQueue<ListNode>minHeap=new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));

        for(ListNode head: lists)
        {
            if(head!=null)
            {
                minHeap.offer(head);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!minHeap.isEmpty())
        {
            ListNode smallest=minHeap.poll();
            curr.next=smallest;
            curr=curr.next;
            if(smallest.next!=null)
            {
                minHeap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}