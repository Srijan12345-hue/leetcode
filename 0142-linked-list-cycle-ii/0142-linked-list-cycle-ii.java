/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head== null || head.next== null) return null;
        ListNode slow= head;
        ListNode fast= head;
        ListNode first= head;
        while(fast !=null && fast.next != null){
            slow= slow.next;
            fast=fast.next.next;
            if(slow==fast){
                while(slow != first){
                    slow=slow.next;
                    first=first.next;

                }
                return first;
            }
        }
        return null;
    }
}