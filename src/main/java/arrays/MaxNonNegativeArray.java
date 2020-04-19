package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 19-Apr-20
 */
public class MaxNonNegativeArray
{
	public ArrayList<Integer> maxset(ArrayList<Integer> values)
	{
		ArrayList<Integer> answer = new ArrayList<>();
		if (values == null || values.size() == 0)
		{
			return answer;
		}

		long maxSum = Integer.MIN_VALUE;
		long currentSum = 0;
		ArrayList<Integer> candidate = new ArrayList<>();
		for (int i = 0; i < values.size(); i++)
		{
			int value = values.get(i);
			if (value < 0 || i == values.size() - 1)
			{
				if (i == values.size() - 1 && value >= 0)
				{
					candidate.add(value);
					currentSum += value;
				}

				if (currentSum > maxSum)
				{
					answer = candidate;
					maxSum = currentSum;
				}
				currentSum = 0;
				candidate = new ArrayList<>();
			}
			else
			{
				candidate.add(value);
				currentSum += value;
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaxNonNegativeArray().maxset(new ArrayList<>(Arrays.asList(2, 4, 2, -6, 1, 2, 5))));
		System.out.println(new MaxNonNegativeArray().maxset(new ArrayList<>(Arrays.asList(756898537, -1973594324, -2038664370, -184803526, 1424268980))));
		System.out.println(new MaxNonNegativeArray().maxset(new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368))));
		System.out.println(new MaxNonNegativeArray().maxset(new ArrayList<>(Arrays.asList(0, 0, -1, 0))));
		System.out.println(new MaxNonNegativeArray().maxset(new ArrayList<>(Arrays.asList(10, -1, 2, 3, -4, 100))));
		System.out.println(new MaxNonNegativeArray().maxset(new ArrayList<>(Arrays.asList(1, 2, 5, -7, 2, 3, 6))));
	}
}
