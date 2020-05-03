package heapsAndMaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
public class NMaxPairCombinations
{
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B)
	{
		A.sort(Collections.reverseOrder());
		B.sort(Collections.reverseOrder());
		int n = A.size();

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : A)
		{
			for (int j : B)
			{
				int s = i + j;
				if (pq.size() < n)
				{
					pq.add(s);
				}
				else
				{
					if (s > pq.peek())
					{
						pq.poll();
						pq.add(s);
					}
					else
					{
						break;
					}
				}
			}
		}

		ArrayList<Integer> ret = new ArrayList<>(pq);
		ret.sort(Collections.reverseOrder());
		return ret;
	}
}
