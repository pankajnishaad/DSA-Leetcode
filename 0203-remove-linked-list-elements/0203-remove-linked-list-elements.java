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
    public ListNode removeElements(ListNode head, int val) {
       
        // Create a dummy node before the actual head.
        // This makes deleting the head node easier.
        ListNode dummy = new ListNode(0);

        // Connect dummy node to the original linked list.
        dummy.next = head;

        // 'current' will be used to traverse the list.
        ListNode current = dummy;

        // Continue until there is no next node.
        while (current.next != null) {

            // Check whether the next node contains the value to remove.
            if (current.next.val == val) {

                // Skip the node that needs to be deleted.
                current.next = current.next.next;

            } else {

                // Move current forward only when we do not delete.
                current = current.next;
            }
        }

        // Return the new head of the linked list.
        return dummy.next;
 
    }
}