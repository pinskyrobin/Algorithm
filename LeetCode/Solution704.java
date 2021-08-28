import java.lang.reflect.Array;

class Solution704 {
    public int search(int[] nums, int target) {
        int len = Array.getLength(nums);
        return binarySearch(nums, 0, len - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end) {
            return (nums[start] == target) ? start : -1;
        }
        int mid = (end + start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid, target);
        }
    }
}