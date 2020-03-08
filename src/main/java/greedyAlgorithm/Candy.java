package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 08-Mar-20
 */
public class Candy
{
	public int candy(ArrayList<Integer> ratings)
	{
		int[] memo = new int[ratings.size()];
		Arrays.fill(memo, 1);

		for (int i = 1; i < ratings.size() - 2; i++)
		{
			int l = 0;
			int r = 0;

			if (ratings.get(i) > ratings.get(i - 1))
			{
				l = memo[i - 1];
			}

			if (ratings.get(i) > ratings.get(i + 1))
			{
				r = memo[i + 1];
			}

			memo[i] = Math.max(l, r) + 1;
		}

		for (int i = 1; i < ratings.size(); i++)
		{
			if (ratings.get(i) > ratings.get(i - 1) && memo[i] <= memo[i - 1])
			{
				memo[i] = memo[i - 1] + 1;
			}
		}

		for (int i = ratings.size() - 2; i >= 0; i--)
		{
			if (ratings.get(i) > ratings.get(i + 1) && memo[i] <= memo[i + 1])
			{
				memo[i] = memo[i + 1] + 1;
			}
		}

		return Arrays.stream(memo).sum();
	}
}
