package tree_dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsForSum {
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

	private static int dfs(TreeNode node, int targetSum, List<Integer> currPath) {
		if (node == null) {
			return 0;
		}
		currPath.add(node.val);
		ListIterator<Integer> listIterator = currPath.listIterator(currPath.size());
		int pathCount = 0;
		long currSum = 0;
		while (listIterator.hasPrevious()) {
			currSum += listIterator.previous();
			if (currSum == targetSum) {
				pathCount++;
			}
		}
		pathCount += dfs(node.left, targetSum, currPath);
		pathCount += dfs(node.right, targetSum, currPath);
		currPath.remove(currPath.size() - 1);
		return pathCount;
	}

	private static int countPaths(TreeNode node, int targetSum) {
		if (node == null) {
			return 0;
		}
		List<Integer> currPath = new LinkedList<Integer>();
		return dfs(node, targetSum, currPath);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int result = countPaths(root, 11);
		System.out.println(result);
	}

}
