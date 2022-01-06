import java.util.Stack;

/***
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CQueue {

    private Stack<Integer> stack_head;
    private Stack<Integer> stack_tail;

    public CQueue() {
        stack_head = new Stack<>();
        stack_tail = new Stack<>();
    }

    public void appendTail(int value) {
        stack_tail.push(value);
    }

    public int deleteHead() {
        // if (stack_tail.empty() && stack_head.empty()) {
        //     return -1;
        // }
        // if (stack_head.empty()) {
        //     int val;
        //     while (!stack_tail.empty()) {
        //         val = stack_tail.pop();
        //         stack_head.push(val);
        //     }
        // }
        // return stack_head.pop();
        if (!stack_head.empty()) {
            return stack_head.pop();
        }
        if (stack_tail.empty()) {
            return -1;
        }
        int val;
        while (!stack_tail.empty()) {
            val = stack_tail.pop();
            stack_head.push(val);
        }
        return stack_head.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */