package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 09-Mar-20
 */
public class LevelOrder
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

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> tempo = new LinkedList<>();
		tempo.addLast(root);
		while (!tempo.isEmpty())
		{
			int currentLevelSize = tempo.size();
			ArrayList<Integer> currentLevelValues = new ArrayList<>();
			while (currentLevelSize > 0)
			{
				TreeNode node = tempo.removeFirst();
				if (node.left != null)
				{
					tempo.addLast(node.left);
				}
				if (node.right != null)
				{
					tempo.addLast(node.right);
				}
				currentLevelValues.add(node.val);

				currentLevelSize--;
			}
			result.add(currentLevelValues);
		}

		return result;
	}
}
