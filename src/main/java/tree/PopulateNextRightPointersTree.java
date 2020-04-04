package tree;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
public class PopulateNextRightPointersTree
{
	public class TreeLinkNode
	{
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x){ val = x; }
	}

	public void connect(TreeLinkNode root)
	{
		TreeLinkNode startLevel = root;
		while (startLevel != null)
		{
			TreeLinkNode current = startLevel;
			TreeLinkNode nextStart = null;
			TreeLinkNode prev = null;
			while (current != null)
			{
				if (nextStart == null)
				{
					nextStart = current.left == null ? current.right : current.left;
				}

				if (current.left != null)
				{
					if (prev != null)
					{
						prev.next = current.left;
					}
					prev = current.left;
				}

				if (current.right != null)
				{
					if (prev != null)
					{
						prev.next = current.right;
					}
					prev = current.right;
				}

				current = current.next;
			}

			startLevel = nextStart;
		}
	}
}
