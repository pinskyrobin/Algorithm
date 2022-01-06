/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Solution557 {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String s2 : s1) {
            stringBuffer.append(new StringBuffer(s2).reverse().toString() + " ");
        }
        return stringBuffer.toString().trim();
    }

    public String reverseString(String str) {
        int start = 0;
        int end = str.length() - 1;
        char temp;
        char[] s = str.toCharArray();
        while (start < end) {
            temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
        return String.valueOf(s);
    }
}
