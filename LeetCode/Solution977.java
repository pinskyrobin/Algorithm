class Solution977 {
    public int[] sortedSquares1(int[] nums) {
        int negIndex;
        int posIndex = 0;
        int newIndex = 0;
        int len = nums.length;
        int[] res = new int[len];
        while (posIndex < len && nums[posIndex] < 0) {
            posIndex++;
        }
        negIndex = posIndex - 1;
        while (negIndex >= 0 && posIndex < len) {
            if (Math.abs(nums[negIndex]) > Math.abs(nums[posIndex])) {
                res[newIndex++] = (int) Math.pow(nums[posIndex++], 2);
            } else {
                res[newIndex++] = (int) Math.pow(nums[negIndex--], 2);
            }
        }
        if (negIndex < 0) {
            while (posIndex < len) {
                res[newIndex++] = (int) Math.pow(nums[posIndex++], 2);
            }
        } else if (posIndex >= len) {
            while (negIndex >= 0) {
                res[newIndex++] = (int) Math.pow(nums[negIndex--], 2);
            }
        }
        return res;
    }

    public int[] sortedSquares2(int[] nums) {
        int start = 0;
        int len = nums.length;
        int end = len - 1;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (nums[start] * nums[start] < nums[end] * nums[end]) {
                res[i] = nums[end] * nums[end];
                end--;
            } else {
                res[i] = nums[start] * nums[start];
                start++;
            }
        }
        return res;
    }
}
