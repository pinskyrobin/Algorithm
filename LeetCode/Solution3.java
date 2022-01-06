import java.util.*;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] c = s.toCharArray();
        int max = 0;
        List<Character> list = new ArrayList<>(c.length);
        int begin = 0;
        for (int end = 0; end < s.length(); end++) {
            if (!list.contains(c[end])) {
                list.add(c[end]);
            } else {
                max = ((end - begin) > max) ? (end - begin) : max;
                while (list.contains(c[end])) {
                    list.set(begin++, ' ');
                }
                list.add(c[end]);
            }
        }
        return max;
    }
}
