package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 14-Feb-20
 */
public class LongestIncreasingSubsequence
{
	public int lis(final List<Integer> nums)
	{
		if (nums == null || nums.size() == 0)
		{
			return 0;
		}

		int[] memo = new int[nums.size()];
		Arrays.fill(memo, 1);

		for (int right = 1; right < nums.size(); right++)
		{
			for (int left = 0; left < right; left++)
			{
				if (nums.get(left) < nums.get(right))
				{
					memo[right] = Math.max(memo[left] + 1, memo[right]);
				}
			}
		}

		int max = 0;
		for (int value: memo)
		{
			max = Math.max(value, max);
		}

		return max;
	}
}
