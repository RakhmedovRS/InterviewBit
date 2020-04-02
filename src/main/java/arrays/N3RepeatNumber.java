package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 02-Apr-20
 */
public class N3RepeatNumber
{
	public int repeatedNumber(final List<Integer> nums)
	{
		List<Integer> rst = new ArrayList<>();
		if (nums == null || nums.size() == 0)
		{
			return -1;
		}

		int count1 = 0;
		int count2 = 0;
		int candidate1 = 0;
		int candidate2 = 1;
		for (int num : nums)
		{
			if (num == candidate1)
			{
				count1++;
			}
			else if (num == candidate2)
			{
				count2++;
			}
			else if (count1 == 0)
			{
				candidate1 = num;
				count1 = 1;
			}
			else if (count2 == 0)
			{
				candidate2 = num;
				count2 = 1;
			}
			else
			{
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for (int num : nums)
		{
			if (num == candidate1)
			{
				count1 += 2;
			}
			else
			{
				count1--;
			}

			if (num == candidate2)
			{
				count2 += 2;
			}
			else
			{
				count2--;
			}
		}

		if (count1 > 0)
		{
			return candidate1;
		}

		if (count2 > 0)
		{
			return candidate2;
		}

		return -1;
	}
}
