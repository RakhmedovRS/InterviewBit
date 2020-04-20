package bitManipulations;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 20-Apr-20
 */
public class DifferentBitsSumPairwise
{
	int BASE = 1000000007;

	public int cntBits(ArrayList<Integer> nums)
	{
		int N = nums.size();
		long res = 0;
		for (int k = 0; k < 32; k++)
		{
			long ones = 0;
			long zeros = 0;
			for (int i = 0; i < N; i++)
			{
				int a = nums.get(i);
				int bit = (a >> k) & 1;
				if (bit == 1)
				{
					ones++;
				}
				else
				{
					zeros++;
				}
			}
			res = (res + (ones * zeros)) % BASE;
		}
		res = (res * 2) % BASE;
		return (int) res;
	}
}
