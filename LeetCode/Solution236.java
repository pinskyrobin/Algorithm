/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution236 {
	// 方式一
//	private TreeNode ret = null;
//
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		dfs(root, p, q);
//		return ret;
//	}
//
//	/**
//	 * 两种种判定成功方式
//	 * 1. p、q分别位于左右子树
//	 * 2. p、q一个在根节点，一个在子树中
// 	 */
//	public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
//		if (root == null)   return false;
//
//		boolean left = dfs(root.left, p, q);
//		boolean right = dfs(root.right, p, q);
//
//		if (left && right || ((root.val == p.val || root.val == q.val) && (left || right)))
//			ret = root;
//
//		return (left || right || (root.val == p.val || root.val == q.val));
//	}

	// 方式二
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null)   return right;
		if (right == null)  return left;

		return root;
	}
}
