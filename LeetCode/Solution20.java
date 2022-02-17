import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution20 {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}
	public static boolean isValid(String s) {
		if (s.length() < 2)    return false;
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			switch (ch) {
				case '{':
				case '[':
				case '(':
					stack.push(ch);
				case '}':
					if (stack.empty() || stack.pop() != '{') return false;
				case ']':
					if (stack.empty() || stack.pop() != '[') return false;
				case ')':
					if (stack.empty() || stack.pop() != '(') return false;
				default:
					return false;
			}
		}
		return stack.empty();
	}
}
