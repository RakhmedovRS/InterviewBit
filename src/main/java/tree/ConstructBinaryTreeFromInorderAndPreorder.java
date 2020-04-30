package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 30-Apr-20
 */
public class ConstructBinaryTreeFromInorderAndPreorder
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

	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder)
	{
		if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0)
		{
			return null;
		}

		Map<Integer, Integer> inOrder = new HashMap<>();
		for (int i = 0; i < inorder.size(); i++)
		{
			inOrder.put(inorder.get(i), i);
		}

		return buildTree(preorder, new int[]{0}, 0, preorder.size() - 1, inOrder);
	}

	private TreeNode buildTree(ArrayList<Integer> preorder, int[] currentPos, int left, int right, Map<Integer, Integer> inOrder)
	{
		if (currentPos[0] == preorder.size() || left < 0 || right >= preorder.size() || left > right)
		{
			return null;
		}

		TreeNode node = new TreeNode(preorder.get(currentPos[0]++));
		node.left = buildTree(preorder, currentPos, left, inOrder.get(node.val) - 1, inOrder);
		node.right = buildTree(preorder, currentPos, inOrder.get(node.val) + 1, right, inOrder);
		return node;
	}
}
