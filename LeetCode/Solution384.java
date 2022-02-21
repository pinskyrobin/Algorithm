import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution384 {
	int[] _nums;

	public Solution384(int[] nums) {
		_nums = nums;
	}

	public int[] reset() {
		return _nums;
	}

	public int[] shuffle() {
		int[] nums = _nums.clone();
		Random rand = new Random();
		for (int i = 0; i < _nums.length; i++) {
			swap(nums, i, i + rand.nextInt(_nums.length - i));
		}
		return nums;
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
