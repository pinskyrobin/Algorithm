import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Solution103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)   return ans;

		boolean reverse = false;
		List<Integer> level = new ArrayList<>();
		List<TreeNode> queue = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.remove(sz - i - 1);
				level.add(node.val);
				if (reverse) {
					if (node.right != null) queue.add(node.right);
					if (node.left != null)  queue.add(node.left);
				} else {
					if (node.left != null)  queue.add(node.left);
					if (node.right != null) queue.add(node.right);
				}
			}
			ans.add(new ArrayList<>(level));
			level.clear();
			reverse = !reverse;
		}
		return ans;
	}
}
