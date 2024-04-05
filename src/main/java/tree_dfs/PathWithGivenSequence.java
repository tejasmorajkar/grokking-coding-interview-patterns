package tree_dfs;

public class PathWithGivenSequence {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int v) {
			this.val = v;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private static boolean helper(TreeNode node, int[] sequence, int seqIdx) {
		if (node == null) {
			return false;
		}
		if (seqIdx >= sequence.length || sequence[seqIdx] != node.val) {
			return false;
		}
		if (node.left == null && node.right == null && seqIdx == sequence.length - 1) {
			return true;
		}
		return helper(node.left, sequence, seqIdx + 1) || helper(node.right, sequence, seqIdx + 1);
	}

	public static boolean findPath(TreeNode root, int[] sequence) {
		return helper(root, sequence, 0);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		boolean result = findPath(root, new int[] { 1, 1, 6 });
		System.out.println(result);
		result = findPath(root, new int[] { 1, 0, 7 });
		System.out.println(result);
	}

}
