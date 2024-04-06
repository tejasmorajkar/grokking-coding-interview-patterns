package tree_dfs;

public class LowestCommonAncestor {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}
	}

	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		TreeNode result = lca(root, root.left, root.left.right.right);
		System.out.println(result.val);
	}

}
