/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findIsland(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void findIsland(char[][] grid, int pos_row, int pos_col) {
        if (pos_row < 0 || pos_row >= grid.length ||
            pos_col < 0 || pos_col >= grid[0].length ||
            grid[pos_row][pos_col] != '1') {
            return;
        }
        grid[pos_row][pos_col] = '2';
        findIsland(grid, pos_row, pos_col - 1);
        findIsland(grid, pos_row, pos_col + 1);
        findIsland(grid, pos_row - 1, pos_col);
        findIsland(grid, pos_row + 1, pos_col);
    }
}
