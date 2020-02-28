package greedyAlgorithm;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
public class HighestProduct
{
	public int maxp3(ArrayList<Integer> nums)
	{
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for (int num : nums)
		{

			if (num <= firstMin)
			{
				secondMin = firstMin;
				firstMin = num;
			}
			else if (num <= secondMin)
			{
				secondMin = num;
			}

			if (num >= firstMax)
			{
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = num;
			}
			else if (num >= secondMax)
			{
				thirdMax = secondMax;
				secondMax = num;
			}
			else if (num > thirdMax)
			{
				thirdMax = num;
			}
		}

		return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
	}
}
