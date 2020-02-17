package dynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 17-Feb-20
 */
public class LongestArithmeticProgression
{
	public int solve(final List<Integer> A)
	{
		if (A == null)
		{
			return 0;
		}

		if(A.size() <= 1)
		{
			return A.size();
		}

		HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();
		for (int i = 0; i < A.size(); i++)
		{
			memo.put(i, new HashMap<>());
		}

		for (int right = 1; right < A.size(); right++)
		{
			for (int left = 0; left < right; left++)
			{
				int diff = A.get(right) - A.get(left);
				HashMap<Integer, Integer> temp = memo.get(right);
				temp.put(diff, memo.get(left).getOrDefault(diff, 1) + 1);
			}
		}

		int max = 0;
		for (Map.Entry<Integer, HashMap<Integer, Integer>> row: memo.entrySet())
		{
			for (Map.Entry<Integer, Integer> entry: row.getValue().entrySet())
			{
				max = Math.max(entry.getValue(), max);
			}
		}

		return max;
	}
}
