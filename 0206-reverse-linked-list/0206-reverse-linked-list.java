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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode d= null;
        ListNode temp= head;
        while(temp != null ){
            ListNode next= temp.next;
            temp.next= d;
            d=temp;
            temp=next;
        }
        return d;
    }
}