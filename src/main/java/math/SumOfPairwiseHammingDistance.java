package math;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
public class SumOfPairwiseHammingDistance
{
	public int hammingDistance(final List<Integer> nums)
	{
		int size = nums.size();
		long result = 0;
		for (int bitPos = 0; bitPos < 32; bitPos++)
		{
			long ones = 0;
			long zeros = 0;
			for (int num : nums)
			{
				int bit = (num >> bitPos) & 1;
				if (bit == 1)
				{
					ones++;
				}
				else
				{
					zeros++;
				}
			}
			result = (result + (ones * zeros)) % 1000000007;
		}
		result = (result * 2) % 1000000007;
		return (int) result;
	}
}
