package arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author RakhmedovRS
 * @created 15-May-20
 */
public class MaximumUnsortedSubarray
{
	public ArrayList<Integer> subUnsort(ArrayList<Integer> A)
	{
		if (A == null || A.size() < 2)
		{
			return new ArrayList<>(Collections.singletonList(-1));
		}
		ArrayList<Integer> res = new ArrayList<>();

		ArrayList<Integer> sorted = new ArrayList<>(A);
		Collections.sort(sorted);
		int n = A.size();
		int f = -1;
		int l = -1;
		for (int i = 0; i < n; i++)
		{
			if (!A.get(i).equals(sorted.get(i)))
			{
				if (f == -1)
				{
					f = i;
				}
				l = i;
			}
		}

		if (l != -1)
		{
			res.add(f);
			res.add(l);
		}
		else
		{
			res.add(-1);
		}
		return res;
	}
}
