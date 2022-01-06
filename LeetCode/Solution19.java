/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode p = head;
        ListNode q = head;
        ListNode r = p.next;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
            r = r.next;
        }
        if (p == head) {
            return head.next;
        }
        p.next = r.next;
        return head;
    }
}
