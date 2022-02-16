import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * https://leetcode-cn.com/problems/permutations/
 */
public class Solution46 {
	List<List<Integer>> ans = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		backtrack(nums, new ArrayList<>());
		return ans;
	}

	public void backtrack(int[] nums, List<Integer> track) {
		if (track.size() == nums.length) {
			ans.add(new ArrayList<>(track));
			return;
		}

		for (int num : nums) {
			if (track.contains(num)) continue;
			track.add(num);
			backtrack(nums, track);
			track.remove(track.size() - 1);
		}
	}
}
