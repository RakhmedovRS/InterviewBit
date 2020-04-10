package linkedLists;

/**
 * @author RakhmedovRS
 * @created 10-Apr-20
 */
public class SwapListNodesInPairs
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

		public ListNode swapPairs(ListNode head)
		{
			if (head == null || head.next == null)
			{
				return head;
			}

			ListNode dummy = new ListNode(0);
			dummy.next = head;
			ListNode current = dummy;
			while (current.next != null && current.next.next != null)
			{
				ListNode first = current.next;
				ListNode second = current.next.next;
				first.next = second.next;
				current.next = second;
				current.next.next = first;
				current = current.next.next;
			}
			return dummy.next;
		}
	}
}
