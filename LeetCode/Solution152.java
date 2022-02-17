import java.util.Map;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution152 {
	public int maxProduct(int[] nums) {
		if (nums.length == 1)   return nums[0];

		int ans = nums[0], maxPrd = nums[0], minPrd = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int max = maxPrd, min = minPrd;
			maxPrd = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
			minPrd = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
			ans = Math.max(ans, maxPrd);
		}
		return ans;
	}
}
