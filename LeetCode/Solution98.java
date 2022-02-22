import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution98 {
	// public boolean isValidBST(TreeNode root) {
	//     if (root.left == null && root.right == null)    return true;
	//     List<Integer> list = new ArrayList<>();
	//     travel(root, list);
	//     int base = list.get(0);
	//     for (int i = 1; i < list.size(); i++) {
	//         if (base >= list.get(i)) return false;
	//         base = list.get(i);
	//     }
	//     return true;
	// }

	// private void travel(TreeNode root, List<Integer> list) {
	//     if (root == null)   return;
	//     travel(root.left, list);
	//     list.add(root.val);
	//     travel(root.right, list);
	// }

	// private void travel(TreeNode root, List<Integer> list) {
	//     Stack<TreeNode> stack = new Stack<>();
	//     while (root != null || !stack.isEmpty()) {
	//         while (root != null) {
	//             stack.push(root);
	//             root = root.left;
	//         }
	//         TreeNode node = stack.pop();
	//         list.add(node.val);
	//         root = node.right;
	//     }
	// }

	public boolean isValidBST(TreeNode root) {
		return cal(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean cal(TreeNode root, long min, long max) {
		if (root == null)                       return true;
		if (root.val <= min || root.val >= max) return false;
		return cal(root.left, min, root.val) && cal(root.right, root.val, max);
	}
}
