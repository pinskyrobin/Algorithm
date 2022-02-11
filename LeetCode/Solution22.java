import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Solution22 {
	List<String> ans = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		cal(n, n, "");
		return ans;
	}

	public void cal(int left, int right, String str) {
		if (left == 0 && right == 0) {
			ans.add(str);
		} else if (left == right) {
			cal(left - 1, right, str + "(");
		} else {
			if (left > 0)  cal(left - 1, right, str + "(");
			cal(left, right - 1, str + ")");
		}
	}
}
