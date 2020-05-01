package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 01-May-20
 */
public class BinaryTreeFromInorderAndPostorder
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

	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder)
	{
		if (inorder == null || inorder.size() == 0 || postorder == null || postorder.size() == 0)
		{
			return null;
		}

		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < inorder.size(); i++)
		{
			cache.put(inorder.get(i), i);
		}

		return buildTree(postorder, 0, postorder.size() - 1, new int[]{postorder.size() - 1}, cache);
	}

	private TreeNode buildTree(ArrayList<Integer> postorder, int left, int right, int[] position, Map<Integer, Integer> cache)
	{
		if (left > right)
		{
			return null;
		}

		TreeNode node = new TreeNode(postorder.get(position[0]--));

		node.right = buildTree(postorder, cache.get(node.val) + 1, right, position, cache);
		node.left = buildTree(postorder, left, cache.get(node.val) - 1, position, cache);
		return node;
	}
}
