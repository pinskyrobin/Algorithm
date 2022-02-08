/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution124 {
	// 改进版本
	int maxSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		int ret = cal(root);
		return Math.max(ret, maxSum);
	}

	public int cal(TreeNode root) {
		if (root == null)   return 0;

		int left = Math.max(cal(root.left), 0);
		int right = Math.max(cal(root.right), 0);

		if (maxSum < left + right + root.val)   maxSum = left + right + root.val;

		return (left > right) ? root.val + left : root.val + right;
	}

	// 自己的初始方案
//	int ans = Integer.MIN_VALUE;
//	public int maxPathSum(TreeNode root) {
//		int ret = getMaxPathSum(root);
//		return Math.max(ret, ans);
//	}
//
//	public int getMaxPathSum(TreeNode root) {
//		if (root == null)   return 0;
//
//		int left, right;
//		if (root.left == null)      left = Integer.MIN_VALUE;
//		else                        left = getMaxPathSum(root.left);
//
//		if (root.right == null)     right = Integer.MIN_VALUE;
//		else                        right = getMaxPathSum(root.right);
//
//		if (left < 0 && right < 0 && root.val > ans)  ans = root.val;
//
//		if (left < 0 && right >= 0 && root.val + right > ans)  ans = root.val + right;
//
//		if (left >= 0 && right < 0 && root.val + left > ans)  ans = root.val + left;
//
//		if (left >= 0 && right >= 0 && left + right + root.val > ans)  ans = left + right + root.val;
//
//		if (left < 0 && right < 0)  return root.val;
//		else                        return (left > right) ? root.val + left : root.val + right;
//	}
}
