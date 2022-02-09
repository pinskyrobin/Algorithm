/**
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 1 || prerequisites.length == 1)   return true;

		int[] ins = new int[numCourses];

		// 初始化
		for (int i = 0; i < numCourses; i++)    ins[i] = 0;

		// 记录出入度
		for (int[] pre : prerequisites) {
			if (pre[0] == pre[1])   return false;
			ins[pre[0]]++;
		}

		int pos = findZeroIn(ins);
		// 如果能找到入度为0的结点
		while(pos != -1 && pos != numCourses) {
			ins[pos]--;
			for (int[] pre : prerequisites)
				if (pre[1] == pos)  ins[pre[0]]--;
			pos = findZeroIn(ins);
		}

		return pos == numCourses;
	}

	/**
	 1. 找到入度为0的结点 => return pos
	 2. 找不到入度为0的结点 => return -1
	 3. 入度全为0 => return numCourses
	 */
	public int findZeroIn(int[] ins) {
		boolean complete = true;

		int i = 0;
		for (; i < ins.length; i++) {
			if (ins[i] == 0)    return i;
			if (ins[i] != -1)   complete = false;
		}
		return complete ? ins.length : -1;
	}
}
