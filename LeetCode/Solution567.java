import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int nums1[] = new int[26];
        int nums2[] = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            nums1[s1.charAt(i)-'a'] += 1;
        }

        int left = 0;
        int right = left + s1.length() - 1;

        for(int i = left; i <= right; i++) {
            nums2[s2.charAt(i)-'a'] += 1;
        }

        if(isEqual(nums1,nums2)) {
            return true;
        }

        while(right < s2.length()){
            nums2[s2.charAt(left) - 'a'] -= 1; //left对应的字符移出滑动窗
            left++;
            right++;
            if(right == s2.length()) //避免right越界
                return false;
            nums2[s2.charAt(right) - 'a'] += 1; //right对应的字符加入滑动窗
            if(isEqual(nums1,nums2))
                return true;
        }
        return false;
    }
    boolean isEqual(int arr1[],int arr2[]){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
