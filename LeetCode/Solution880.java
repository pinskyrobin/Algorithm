/**
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 *
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decoded-string-at-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution880 {
	// 内存超出限制
//	public String decodeAtIndex(String s, int k) {
//		StringBuilder buf = new StringBuilder();
//		StringBuilder temp = new StringBuilder();
//		int index = 0, times;
//		for (char ch : s.toCharArray()) {
//			if (ch >= '0' && ch <= '9') {
//				times = ch - '0';
//				for (int i = 0; i < times; i++) {
//					temp.append(buf);
//				}
//				buf.setLength(0);
//				buf.append(temp);
//				temp.setLength(0);
//				index = buf.length();
//				if (index >= k) return String.valueOf(temp.charAt(k - 1));
//			} else {
//				buf.append(ch);
//			}
//		}
//		return String.valueOf(buf.charAt(k - 1));
//	}
	public static void main(String[] args) {
		System.out.println(decodeAtIndex("leet2code3", 10));
	}

	public static String decodeAtIndex(String s, int k) {
		long len = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch))  len *= ch - '0';
			else                        len++;
		}
		for (int i = s.length() - 1; i >= 0; --i) {
			char c = s.charAt(i);
			k %= len;
			if (k == 0 && Character.isLetter(c))
				return Character.toString(c);

			if (Character.isDigit(c))
				len /= c - '0';
			else
				len--;
		}
		return null;
	}
}
