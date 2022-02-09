import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution3 {
    // 初始方案
    // public int lengthOfLongestSubstring(String s) {
    //     if (s.length() < 2)    return s.length();

    //     int ans = 0;
    //     int start = 0;
    //     int cur = 0;
    //     char[] str = s.toCharArray();
    //     List<Character> charList = new ArrayList<>();
    //     for (cur = 0; cur < str.length; cur++) {
    //         if (!charList.contains(str[cur])) {
    //             charList.add(str[cur]);
    //         } else {
    //             ans = Math.max((cur - start), ans);
    //             while (charList.contains(str[cur])) {
    //                 charList.remove(0);
    //                 start++;
    //             }
    //             charList.add(str[cur]);
    //         }
    //     }
    //     return Math.max((cur - start), ans);
    // }
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int start = 0, cur = 0;
        int ans = 0;
        char[] str = s.toCharArray();
        Set<Character> set = new HashSet<>(str.length);

        for (; cur < str.length; cur++) {
            if (set.contains(str[cur])) {
                ans = Math.max((cur - start), ans);
                while (set.contains(str[cur]))
                    set.remove(str[start++]);
            }
            set.add(str[cur]);
        }

        return Math.max((cur - start), ans);

    }
}
