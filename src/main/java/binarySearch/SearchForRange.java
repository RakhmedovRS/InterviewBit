package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 30-Apr-20
 */
public class SearchForRange
{
	public ArrayList<Integer> searchRange(final List<Integer> nums, int target)
	{
		ArrayList<Integer> answer = new ArrayList<>(Arrays.asList(-1, -1));
		if (nums == null || nums.size() == 0)
		{
			return answer;
		}

		int left = 0;
		int right = nums.size() - 1;
		int middle = -1;
		while (left <= right)
		{
			middle = left + (right - left) / 2;
			if (nums.get(middle) == target)
			{
				break;
			}
			else if (target < nums.get(middle))
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}

		if (nums.get(middle) == target)
		{
			int mid = middle;

			answer.set(0, mid);
			left = 0;
			right = middle - 1;
			while (left <= right)
			{
				middle = left + (right - left) / 2;
				if (nums.get(middle) == target)
				{
					answer.set(0, middle);
					right = middle - 1;
				}
				else
				{
					left = middle + 1;
				}
			}

			answer.set(2, mid);
			left = mid + 1;
			right = nums.size() - 1;
			while (left <= right)
			{
				middle = left + (right - left) / 2;
				if (nums.get(middle) == target)
				{
					answer.set(2, middle);
					left = middle + 1;
				}
				else
				{
					right = middle - 1;
				}
			}
		}


		return answer;
	}
}
