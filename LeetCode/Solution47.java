import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Solution47 {
	List<List<Integer>> ans = new ArrayList<>();
	boolean[] checked;
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		checked = new boolean[nums.length];
		backtrack(nums, new ArrayList<>());
		return ans;
	}

	public void backtrack(int[] nums, List<Integer> track) {
		if (track.size() == nums.length) {
			if (!ans.contains(track))    ans.add(new ArrayList<>(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (checked[i] || (i > 0 && nums[i] == nums[i - 1] && !checked[i - 1]))    continue;
			track.add(nums[i]);
			checked[i] = true;
			backtrack(nums, track);
			track.remove(track.size() - 1);
			checked[i] = false;
		}
	}
}
