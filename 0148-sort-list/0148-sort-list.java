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

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // Find the middle of the list
    public ListNode middle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge Sort
    public ListNode mergeSort(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode middle = middle2(head);

        // Divide into two lists
        ListNode rightHead = middle.next;
        middle.next = null;

        ListNode leftHead = head;

        // Sort both halves
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        // Merge both sorted halves
        return merge(leftHead, rightHead);
    }

    // Merge two sorted linked lists
    public ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (head1 != null && head2 != null) {

            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } 
            else {
                temp.next = head2;
                head2 = head2.next;
            }

            // Move temp
            temp = temp.next;
        }

        // Remaining nodes of head1
        while (head1 != null) {
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }

        // Remaining nodes of head2
        while (head2 != null) {
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }

        return dummy.next;
    }
}