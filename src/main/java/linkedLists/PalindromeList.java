package linkedLists;

/**
 * @author RakhmedovRS
 * @created 01-Apr-20
 */
public class PalindromeList
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

	public int lPalin(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return 1;
		}

		if (head.next.next == null)
		{
			return head.val == head.next.val ? 1 : 0;
		}

		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		dummy1.next = head;

		int nodeCount = 0;
		while (head != null)
		{
			nodeCount++;
			head = head.next;
		}

		ListNode slow = dummy1.next;
		ListNode fast = slow.next.next;
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		if (nodeCount % 2 == 0)
		{
			dummy2.next = reverseList(slow.next);
		}
		else
		{
			dummy2.next = reverseList(slow.next.next);
		}
		slow.next = null;

		ListNode first = dummy1.next;
		ListNode second = dummy2.next;
		while (first != null && second != null)
		{
			if (first.val != second.val)
			{
				return 0;
			}

			first = first.next;
			second = second.next;
		}

		return (first == null && second == null) ? 1 : 0;
	}

	private ListNode reverseList(ListNode node)
	{
		ListNode next;
		ListNode prev = null;
		while (node != null)
		{
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}

		return prev;
	}
}
