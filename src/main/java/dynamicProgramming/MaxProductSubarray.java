package dynamicProgramming;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12-Mar-20
 */
public class MaxProductSubarray
{
	public int maxProduct(final List<Integer> nums)
	{
		if (nums == null || nums.size() == 0)
		{
			return 0;
		}

		int currentMin = nums.get(0);
		int currentMax = nums.get(0);
		int finalMax = nums.get(0);
		for (int i = 1; i < nums.size(); i++)
		{
			int temp = currentMax;
			currentMax = Math.max(nums.get(i), Math.max(currentMax * nums.get(i), currentMin * nums.get(i)));
			currentMin = Math.min(nums.get(i), Math.min(temp * nums.get(i), currentMin * nums.get(i)));

			if (currentMax > finalMax)
			{
				finalMax = currentMax;
			}
		}

		return finalMax;
	}
}
