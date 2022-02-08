/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class Solution53 {
	public int maxSubArray(int[] nums) {

		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + Math.max(nums[i - 1], 0);
			res = Math.max(nums[i], res);
		}

		return res;
	}
}
