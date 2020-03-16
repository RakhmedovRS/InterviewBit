package greedyAlgorithm;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 16-Mar-20
 */
public class GasStation
{
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost)
	{
		int tank = 0;
		for (int i = 0; i < gas.size(); i++)
		{
			tank += gas.get(i) - cost.get(i);
		}
		if (tank < 0)
		{
			return -1;
		}

		int start = 0;
		int accumulate = 0;
		for (int i = 0; i < gas.size(); i++)
		{
			int curGain = gas.get(i) - cost.get(i);
			if (accumulate + curGain < 0)
			{
				start = i + 1;
				accumulate = 0;
			}
			else
			{
				accumulate += curGain;
			}
		}

		return start;
	}
}
