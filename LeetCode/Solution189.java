class Solution189 {
    public void rotate(int[] nums, int k) {
        subRotate(nums, 0, k % nums.length);
    }

    public void subRotate(int[] nums, int startIndex, int k) {
        int len = nums.length;
        if (k == 0 || k % nums.length == 0 || startIndex == len - 1) {
            return;
        }
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[startIndex + i];
            nums[startIndex + i] = nums[len - k + i];
            nums[len - k + i] = temp;
        }
        subRotate(nums, startIndex + k, k % (len - startIndex - k));
    }
}
