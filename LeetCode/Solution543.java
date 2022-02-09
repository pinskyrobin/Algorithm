/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class Solution543 {
	int maxLen = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		cal(root);
		return maxLen - 1;
	}

	public int cal(TreeNode root) {
		if (root == null)   return 0;

		int left = cal(root.left);
		int right = cal(root.right);

		maxLen = Math.max(left + right + 1, maxLen);

		return (left > right) ? left + 1 : right + 1;
	}
}
