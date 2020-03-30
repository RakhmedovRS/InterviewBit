package twoPointers;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
public class MinimizeTheAbsoluteDifference
{
	public int solve(
		ArrayList<Integer> A,
		ArrayList<Integer> B,
		ArrayList<Integer> C)
	{

		if (A == null || B == null || C == null)
		{
			return 0;
		}
		if (A.isEmpty() || B.isEmpty() || C.isEmpty())
		{
			return 0;
		}

		int aCounter = A.size() - 1;
		int bCounter = B.size() - 1;
		int cCounter = C.size() - 1;
		int a;
		int b;
		int c;

		int res = Integer.MAX_VALUE;
		int diff;
		while (aCounter >= 0 && bCounter >= 0 && cCounter >= 0)
		{
			a = A.get(aCounter);
			b = B.get(bCounter);
			c = C.get(cCounter);
			diff = calcDiff(a, b, c);
			if (res > diff)
			{
				res = diff;
			}

			if (a >= b && a >= c)
			{
				aCounter--;
			}
			else if (b >= a && b >= c)
			{
				bCounter--;
			}
			else
			{
				cCounter--;
			}
		}

		return res;
	}

	int calcDiff(int a, int b, int c)
	{
		int max = Math.max(Math.max(a, b), c);
		int min = Math.min(Math.min(a, b), c);
		return Math.abs(max - min);
	}
}
