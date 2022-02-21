import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */

public class Solution102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)   return ans;
		// 充当BFS的队列
		List<TreeNode> treeNodes = new ArrayList<>();
		treeNodes.add(root);
		while(!treeNodes.isEmpty()) {
			int size = treeNodes.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = treeNodes.remove(0);
				list.add(node.val);
				if (node.left != null)     treeNodes.add(node.left);
				if (node.right != null)    treeNodes.add(node.right);
			}
			ans.add(list);
		}
		return ans;
	}
}
