/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }
        int start = 0;
        while (start < len - 1 && nums[start] != 0) {
            start++;
        }
        int target = start + 1;
        int temp;
        while (target < len) {
            if (nums[target] != 0) {
                temp = nums[start];
                nums[start] = nums[target];
                nums[target] = temp;
                start++;
            }
            target++;
        }
    }
}
