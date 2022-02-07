/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution206 {
	// 迭代
	// public ListNode reverseList(ListNode head) {
	//     if (head == null || head.next == null)  return head;

	//     ListNode p = null, q = head, r;
	//     while(q != null) {
	//         r = q.next;
	//         q.next = p;
	//         p = q;
	//         q = r;
	//     }

	//     return p;
	// }

	//递归
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode ret = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return ret;
	}
}
