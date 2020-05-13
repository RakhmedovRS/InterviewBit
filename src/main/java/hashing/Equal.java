package hashing;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author RakhmedovRS
 * @created 13-May-20
 */
public class Equal
{
	public ArrayList<Integer> equal(ArrayList<Integer> A)
	{
		int sum = 0;
		ArrayList<Integer> ans = null;
		Hashtable<Integer, ArrayList<Integer>> ht = new Hashtable<Integer, ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++)
		{
			for (int j = i + 1; j < A.size(); j++)
			{
				sum = A.get(i) + A.get(j);
				if (ht.containsKey(sum))
				{
					ArrayList<Integer> a = ht.get(sum);
					if (a.get(0) != i && a.get(1) != j && a.get(0) != j && a.get(1) != i)
					{
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(a.get(0));
						tmp.add(a.get(1));
						tmp.add(i);
						tmp.add(j);
						if (ans == null)
						{
							ans = tmp;
						}
						else
						{
							for (int k = 0; k < 4; k++)
							{
								if (ans.get(k) < tmp.get(k))
								{
									break;
								}
								else if (ans.get(k) > tmp.get(k))
								{
									ans = tmp;
									break;
								}
							}
						}
					}
				}
				else
				{
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(i);
					l.add(j);
					ht.put(sum, l);
				}
			}
		}
		return ans;
	}
}
