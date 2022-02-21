/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int add = 0;
		ListNode head = new ListNode();
		ListNode curr = head;
		while (l1 != null || l2 != null) {
			int val1 = (l1 == null) ? 0 : l1.val;
			int val2 = (l2 == null) ? 0 : l2.val;
			int val = val1 + val2 + add;
			ListNode node = new ListNode(val % 10);
			curr.next = node;
			curr = node;
			add = val / 10;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		if (add != 0) curr.next = new ListNode(1);
		return head.next;
	}
}
