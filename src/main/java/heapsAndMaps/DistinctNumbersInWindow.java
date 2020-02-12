package heapsAndMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12-Feb-20
 */
public class DistinctNumbersInWindow
{
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B)
	{
		ArrayList<Integer> result = new ArrayList<>();
		if (A == null || A.isEmpty() || B <= 0)
		{
			return result;
		}

		Map<Integer, Integer> numbers = new HashMap<>();

		for (int i = 0; i <= A.size(); i++)
		{
			if (i < B)
			{
				numbers.put(A.get(i), numbers.getOrDefault(A.get(i), 0) + 1);
			}
			else if (i == A.size())
			{
				result.add(numbers.size());
			}
			else
			{
				result.add(numbers.size());

				if (numbers.get(A.get(i - B)).equals(1))
				{
					numbers.remove(A.get(i - B));
				}
				else
				{
					numbers.compute(A.get(i - B), (key, value) -> --value);
				}

				numbers.put(A.get(i), numbers.getOrDefault(A.get(i), 0) + 1);
			}
		}

		return result;
	}
}
