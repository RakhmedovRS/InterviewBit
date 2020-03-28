package arrays;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 28-Mar-20
 */
public class RepeatAndMissingNumberArray
{
	public ArrayList<Integer> repeatedNumber(List<Integer> numbers)
	{
		ArrayList<Integer> answer = new ArrayList<>(2);
		answer.add(0);
		answer.add(0);
		Map<Integer, Integer> memo = new HashMap<>();
		for (Integer value : numbers)
		{
			memo.put(value, memo.getOrDefault(value, 0) + 1);
		}

		for (int i = 1; i <= numbers.size(); i++)
		{
			Integer count = memo.get(i);
			if (count == null)
			{
				answer.set(1, i);
			}
			else if (count > 1)
			{
				answer.set(0, i);
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new RepeatAndMissingNumberArray().repeatedNumber(new ArrayList<>(Arrays.asList(3, 1, 2, 5, 3))));
	}
}
