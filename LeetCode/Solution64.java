/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution64 {
	public int minPathSum(int[][] grid) {
		int row = grid.length, col = grid[0].length;
		int[][] dp = new int[row][col];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (i == 0 && j == 0)   dp[i][j] = grid[0][0];
				else if (i == 0)        dp[i][j] = dp[i][j - 1] + grid[i][j];
				else if (j == 0)        dp[i][j] = dp[i - 1][j] + grid[i][j];
				else                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

		return dp[row - 1][col - 1];
	}
}
