/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)   return root;

		// 递归左子树
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
			// 递归右子树
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			// 单侧或叶子结点，直接删除
			if (root.left == null || root.right == null)
				root = (root.left == null) ? root.right : root.left;
			else {
				// 否则，寻找左子树最大结点替代根结点
				TreeNode cur = root.left;
				while(cur.right != null) {
					cur = cur.right;
				}
				root.val = cur.val;
				root.left = deleteNode(root.left, cur.val);
			}
		}
		return root;
	}
}
