import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
	public int[][] merge(int[][] intervals) {
		List<int[]> ans = new ArrayList<>();

		if (intervals.length == 1) {
			ans.add(new int[] {intervals[0][0], intervals[0][1]});
			return ans.toArray(new int[ans.size()][2]);
		}

		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		ans.add(new int[] {intervals[0][0], intervals[0][1]});

		for (int i = 1; i < intervals.length; i++) {
			if (ans.get(ans.size() - 1)[1] >= intervals[i][1])
				continue;
			if (ans.get(ans.size() - 1)[1] >= intervals[i][0])
				ans.set(ans.size() - 1, new int[] {ans.get(ans.size() - 1)[0], intervals[i][1]});
			else
				ans.add(new int[] {intervals[i][0], intervals[i][1]});
		}

		return ans.toArray(new int[ans.size()][2]);
	}
}
