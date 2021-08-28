import java.lang.reflect.Array;

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        } else if (nums[Array.getLength(nums)] < target) {
            return Array.getLength(nums) + 1;
        }
        int low = 0;
        int high = Array.getLength(nums) - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] >= target) {
            return low;
        } else {
            return low + 1;
        }
    }
}