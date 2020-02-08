package tree;

/**
 * @author RakhmedovRS
 * @created 08-Feb-20
 */
public class NextGreaterNumberBST
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public TreeNode findMin(TreeNode treeNode)
	{
		if (treeNode == null)
		{
			return null;
		}

		while (treeNode.left != null)
		{
			treeNode = treeNode.left;
		}

		return treeNode;
	}

	public TreeNode getSuccessor(TreeNode a, int b)
	{
		TreeNode root = a;
		TreeNode lastLeft = null;
		if (root == null)
		{
			return null;
		}
		while (root.val != b)
		{
			if (root.val < b)
			{
				root = root.right;
			}
			else
			{
				lastLeft = root;
				root = root.left;
			}
		}

		if (root.right != null)
		{
			TreeNode minTreeNode = root.right;
			while (minTreeNode.left != null)
			{
				minTreeNode = minTreeNode.left;
			}
			return findMin(root.right);
		}
		else
		{
			return lastLeft;
		}
	}
}
