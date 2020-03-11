package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-Mar-20
 */
public class NDigitNumbersWithDigitSumS
{
	private long solve(int length, int sum, Map<Integer, Map<Integer, Integer>> cache)
	{
		if (length == 0)
		{
			return sum == 0 ? 1 : 0;
		}

		if (cache.get(length) != null)
		{
			Integer res = cache.get(length).get(sum);
			if (res != null)
			{
				return res;
			}
		}

		int answer = 0;
		for (int i = 0; i <= 9; i++)
		{
			if (sum - i >= 0)
			{
				answer += solve(length - 1, sum - i, cache);
				answer %= 1000000007;
			}
		}

		if (!cache.containsKey(length))
		{
			cache.put(length, new HashMap<>());
		}

		cache.get(length).put(sum, answer);

		return answer;
	}

	public int solve(int length, int sum)
	{
		int answer = 0;
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
		for (int i = 1; i <= 9; i++)
		{
			if (sum - i >= 0)
			{
				answer += solve(length - 1, sum - i, cache);
				answer %= 1000000007;
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new NDigitNumbersWithDigitSumS().solve(4, 6));
	}
}
