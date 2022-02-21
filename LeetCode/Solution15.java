import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();

		// 特判
		if (nums.length < 3 || (nums.length == 3 && nums[0] + nums[1] + nums[2] != 0))
			return ans;

		Arrays.sort(nums);
		// 全正（不可能三数相加为0）
		if (nums[0] > 0)    return ans;

		int low, high;
		for (int i = 0; i < nums.length; i++) {
			// 接下来的数全正
			if (nums[i] > 0)                        continue;
			// 当前值与上一个相同
			if (i > 0 && nums[i - 1] == nums[i])    continue;
			low = i + 1;
			high = nums.length - 1;
			while (low < high) {
				// 和为0，添加到答案，同时更新low和high
				if (nums[i] + nums[low] + nums[high] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[low]);
					list.add(nums[high]);
					ans.add(list);
					low++;
					high--;
					// 跳过相同的值保证结果不重复
					while (low < high && nums[low - 1] == nums[low])    low++;
					while (low < high && nums[high] == nums[high + 1])  high--;
				}
				// 和小于0，low右移使得三数和变大
				else if (nums[i] + nums[low] + nums[high] < 0)  low++;
				// 和大于0，high左移使得三数和变小
				else                                            high--;
			}
		}
		return ans;
	}
}
