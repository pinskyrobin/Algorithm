/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution151 {
	public String reverseWords(String s) {
		StringBuilder buffer = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		boolean finish = false;
		char[] str = s.toCharArray();

		int begin = 0, end = str.length - 1;
		while (str[begin] == ' ')   begin++;
		while (str[end] == ' ')     end--;

		for (int i = end; i >= begin; i--) {
			if (str[i] == ' ' && !finish) {
				finish = true;
				ans.append(buffer.reverse()).append(" ");
				buffer.setLength(0);
			}
			else if (str[i] != ' ') {
				finish = false;
				buffer.append(str[i]);
			}
		}

		return ans.append(buffer.reverse()).toString();
	}
}
