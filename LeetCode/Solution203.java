/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Solution203 {
	// 迭代
//	public ListNode removeElements(ListNode head, int val) {
//		if (head == null)       return head;
//		if (head.next == null)  return (head.val == val) ? null : head;
//
//		ListNode pre = head;
//		ListNode curr = head.next;
//
//		while (curr != null) {
//			if (curr.val == val)    pre.next = curr.next;
//			else                    pre = pre.next;
//			curr = curr.next;
//		}
//
//		if (head.val == val)    head = head.next;
//
//		return head;
//	}
	// 递归
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)       return null;
		head.next = removeElements(head.next, val);
		if (head.val == val)    return head.next;
		else                    return head;
	}
}
