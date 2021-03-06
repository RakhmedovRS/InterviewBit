package linkedLists;

/**
 * @author RakhmedovRS
 * @created 04-Mar-20
 */
public class SortList
{
	class ListNode
	{
		public int val;
		public ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}

	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode temp = head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null)
		{
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		temp.next = null;

		ListNode leftPart = sortList(head);
		ListNode rightPart = sortList(slow);

		return merge(leftPart, rightPart);
	}

	private ListNode merge(ListNode left, ListNode right)
	{
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while (left != null && right != null)
		{
			if (left.val > right.val)
			{
				current.next = right;
				right = right.next;
			}
			else
			{
				current.next = left;
				left = left.next;
			}
			current = current.next;
		}

		while (left != null)
		{
			current.next = left;
			left = left.next;
			current = current.next;
		}

		while (right != null)
		{
			current.next = right;
			right = right.next;
			current = current.next;
		}

		return dummy.next;
	}
}
