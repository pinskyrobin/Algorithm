/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Solution14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 1)   return strs[0];

		StringBuilder sb = new StringBuilder();
		boolean consistent = true;
		int index = -1;
		while (consistent) {
			if (strs[0].length() < index + 1) break;
			char ch = strs[0].charAt(++index);
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() <= index || strs[i].charAt(index) != ch) {
					consistent = false;
					break;
				}
			}
			if (consistent) sb.append(ch);
		}

		return sb.toString();
	}
}
