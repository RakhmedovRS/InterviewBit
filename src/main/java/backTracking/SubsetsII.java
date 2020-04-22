package backTracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
public class SubsetsII
{
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> values)
	{
		Collections.sort(values);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		req(values, res, 0);
		return res;
	}

	void req(ArrayList<Integer> values, ArrayList<ArrayList<Integer>> res, int startPos)
	{
		if (startPos == values.size())
		{
			return;
		}
		ArrayList<Integer> prev = res.get(res.size() - 1);
		Integer last = null;
		for (int i = startPos; i < values.size(); i++)
		{
			if (values.get(i).equals(last))
			{
				continue;
			}
			last = values.get(i);
			ArrayList<Integer> a = new ArrayList<>(prev);
			a.add(values.get(i));
			res.add(a);
			req(values, res, i + 1);
		}
	}
}
