package tree;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
public class InorderTraversalOfCartesianTree
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
			left = null;
			right = null;
		}
	}

	public TreeNode buildTree(ArrayList<Integer> inorder)
	{
		return build(inorder, 0, inorder.size() - 1);
	}

	TreeNode build(ArrayList<Integer> inorder, int left, int right)
	{
		if (left > right)
		{
			return null;
		}
		int middle = max(inorder, left, right);
		TreeNode node = new TreeNode(inorder.get(middle));
		node.left = build(inorder, left, middle - 1);
		node.right = build(inorder, middle + 1, right);
		return node;
	}

	int max(ArrayList<Integer> inorder, int left, int right)
	{
		int max = left;
		for (int i = left; i <= right; i++)
		{
			if (inorder.get(i) > inorder.get(max))
			{
				max = i;
			}
		}
		return max;
	}
}
