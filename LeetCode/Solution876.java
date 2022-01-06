/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */

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
class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode last = head;
        while (last != null && last.next != null) {
            mid = mid.next;
            last = last.next.next;
        }
        return mid;
    }
}
