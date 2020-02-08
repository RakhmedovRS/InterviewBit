package tree;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 08-Feb-20
 */
public class KthSmallestElementInTree
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

		public void kthSmallest(TreeNode root, LinkedList<Integer> values, int k)
		{
			if (root == null)
			{
				return;
			}

			if (values.size() == k)
			{
				return;
			}

			if (root.left == null && root.right == null)
			{
				values.add(root.val);
				return;
			}

			kthSmallest(root.left, values, k);
			if (values.size() == k)
			{
				return;
			}
			else
			{
				values.add(root.val);
			}
			kthSmallest(root.right, values, k);
		}

		public int kthsmallest(TreeNode root, int k)
		{
			LinkedList<Integer> values = new LinkedList<>();
			kthSmallest(root, values, k);
			return values.getLast();
		}
	}
}
