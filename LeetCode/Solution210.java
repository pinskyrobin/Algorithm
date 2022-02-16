/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int ansIndex = 0;
		int[] ans = new int[numCourses];
		int[] ins = new int[numCourses];

		// 如果没有先修限制
		if (prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				ans[i] = i;
			}
			return ans;
		}

		// 标记每门课结点的入度
		for (int[] prerequisite : prerequisites) {
			ins[prerequisite[0]]++;
		}

		// 寻找可以选的课
		int available = findAvailable(ins);
		while (available != numCourses) {
			if (available == -1)    return new int[0];

			ans[ansIndex++] = available;
			ins[available] = -1;
			for (int[] prerequisite : prerequisites) {
				if (prerequisite[1] == available)   ins[prerequisite[0]]--;
			}

			available = findAvailable(ins);
		}

		return ans;
	}

	public int findAvailable(int[] ins) {
		boolean complete = true, find = false;
		for (int i = 0; i < ins.length; i++) {
			if (ins[i] == 0)    return i;
			if (ins[i] > 0)     complete = false;
		}

		return complete ? ins.length : -1;
	}
}
