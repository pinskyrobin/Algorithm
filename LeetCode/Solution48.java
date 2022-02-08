/**
 * 给定一个 n×n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution48 {

	// 先上下翻转，后转置
	public void rotate(int[][] matrix) {
		if (matrix.length == 1) return;

		int sz = matrix.length;
		int tempVal;
		int[] tempVec = new int[sz];

		for (int i = 0; i < sz / 2; i++) {
			tempVec = matrix[i];
			matrix[i] = matrix[sz - 1 - i];
			matrix[sz - 1 - i] = tempVec;
		}

		for (int i = 0; i < sz; i++) {
			for (int j = i + 1; j < sz; j++) {
				tempVal = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tempVal;
			}
		}
	}
}
