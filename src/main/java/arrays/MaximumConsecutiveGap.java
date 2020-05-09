package arrays;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 09-May-20
 */
public class MaximumConsecutiveGap
{
	public int maximumGap(final List<Integer> nums)
	{
		if (nums == null || nums.size() < 2)
		{
			return 0;
		}

		nums.sort(null);

		int maxDiff = 0;
		for (int i = 1; i < nums.size(); i++)
		{
			int diff = nums.get(i) - nums.get(i - 1);
			if (diff > maxDiff)
			{
				maxDiff = diff;
			}
		}

		return maxDiff;
	}
}
