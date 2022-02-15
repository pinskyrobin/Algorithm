import java.util.Arrays;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
class Solution32 {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];

        int index = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                index = i - dp[i - 1] - 1;
                if (index >= 0 && str[index] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (index > 0)
                        dp[i] += dp[index - 1];
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
