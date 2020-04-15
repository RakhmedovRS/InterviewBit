package arrays;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 15-Apr-20
 */
public class MaxDistance
{
	public int maximumGap(final List<Integer> values)
	{
		int maxGap = 0;
		if (values == null || values.size() <= 1)
		{
			return 0;
		}

		int[] min = new int[values.size()];
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < values.size(); i++)
		{
			if (minValue > values.get(i))
			{
				minValue = values.get(i);
			}
			min[i] = minValue;
		}

		int[] max = new int[values.size()];
		int maxValue = Integer.MIN_VALUE;
		for (int i = values.size() - 1; i >= 0; i--)
		{
			if (values.get(i) > maxValue)
			{
				maxValue = values.get(i);
			}
			max[i] = maxValue;
		}

		int i = 0;
		int j = 0;
		while (i < values.size() && j < values.size())
		{
			if (min[i] <= max[j])
			{
				maxGap = Math.max(maxGap, j - i);
				j++;
			}
			else
			{
				i++;
			}
		}

		return maxGap;
	}
}
