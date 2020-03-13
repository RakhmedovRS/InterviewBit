package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 13-Mar-20
 */
public class LengthOfLongestSubsequence
{
	public int longestSubsequenceLength(final List<Integer> nums)
	{
		if (nums == null || nums.size() == 0)
		{
			return 0;
		}

		int[] forward = new int[nums.size()];
		int[] backward = new int[nums.size()];
		Arrays.fill(forward, 1);
		Arrays.fill(backward, 1);
		for (int right = 1; right < forward.length; right++)
		{
			for (int left = 0; left < right; left++)
			{
				if (nums.get(left) <= nums.get(right))
				{
					forward[right] = Math.max(forward[right], forward[left] + 1);
				}
			}
		}

		for (int left = backward.length - 2; left >= 0; left--)
		{
			for (int right = backward.length - 1; left < right; right--)
			{
				if (nums.get(left) >= nums.get(right))
				{
					backward[left] = Math.max(backward[right] + 1, backward[left]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < forward.length; i++)
		{
			max = Math.max(max, (forward[i] + backward[i]) - 1);
		}

		return max;
	}
}
