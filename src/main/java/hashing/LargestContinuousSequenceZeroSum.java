package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
public class LargestContinuousSequenceZeroSum
{
	public ArrayList<Integer> lszero(ArrayList<Integer> A)
	{
		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		int start = 0;
		int end = 0;
		int prefixSum = 0;
		map.put(0, -1);
		for (int i = 0; i < A.size(); i++)
		{
			prefixSum += A.get(i);
			Integer index = map.get(prefixSum);
			if (index != null)
			{
				if (i - index > end - start)
				{
					start = index;
					end = i;
				}
			}
			else
			{
				map.put(prefixSum, i);
			}
		}

		for (int i = start + 1; i <= end; i++)
		{
			result.add(A.get(i));
		}

		return result;
	}
}
