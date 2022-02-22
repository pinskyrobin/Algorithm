import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Solution94 {
	// 递归
	// public List<Integer> inorderTraversal(TreeNode root) {
	//     if (root == null)   return new ArrayList<Integer>();
	//     List<Integer> list = new ArrayList<>();
	//     travel(root, list);
	//     return list;
	// }

	// public void travel(TreeNode root, List<Integer> ans) {
	//     if (root == null)   return;
	//     travel(root.left, ans);
	//     ans.add(root.val);
	//     travel(root.right, ans);
	// }

	// 迭代
//	public List<Integer> inorderTraversal(TreeNode root) {
//		if (root == null)   return new ArrayList<Integer>();
//		List<Integer> list = new ArrayList<>();
//		Stack<TreeNode> stack = new Stack<>();
//		TreeNode curr = root;
//		while (curr != null || !stack.isEmpty()) {
//			if (curr != null) {
//				stack.push(curr);
//				curr = curr.left;
//			} else {
//				curr = stack.pop();
//				list.add(curr.val);
//				curr = curr.right;
//			}
//		}
//		return list;
//	}

	// Moris
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)   return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<>();
		TreeNode curr;
		while (root != null) {
			if (root.left != null) {
				curr = root.left;
				while (curr.right != null && curr.right != root)    curr = curr.right;
				if (curr.right == null) {
					curr.right = root;
					root = root.left;
				} else {
					list.add(root.val);
					curr.right = null;
					root = root.right;
				}
			} else {
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}
}
