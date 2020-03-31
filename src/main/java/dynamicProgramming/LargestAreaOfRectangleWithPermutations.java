package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author RakhmedovRS
 * @created 31-Mar-20
 */
public class LargestAreaOfRectangleWithPermutations
{
	public int solve(ArrayList<ArrayList<Integer>> A)
	{
		ArrayList<ArrayList<Integer>> hist = new ArrayList<>();

		for (int i = 0; i < A.size(); i++)
		{
			ArrayList<Integer> row = A.get(i);
			ArrayList<Integer> histRow = new ArrayList<>();
			for (int j = 0; j < row.size(); j++)
			{
				int count = 0;
				if (row.get(j) == 1)
				{
					count = 1;
					if (i != 0)
					{
						count += hist.get(i - 1).get(j);
					}
				}
				histRow.add(count);
			}
			hist.add(histRow);
		}

		for (ArrayList<Integer> row : hist)
		{
			row.sort(Collections.reverseOrder());
		}

		int maxArea = 0;
		for (ArrayList<Integer> row : hist)
		{
			for (int j = 0; j < row.size(); j++)
			{
				maxArea = Math.max(maxArea, (j + 1) * row.get(j));
			}
		}

		return maxArea;
	}

	public static void main(String[] args)
	{
		System.out.println(new LargestAreaOfRectangleWithPermutations().solve(
			new ArrayList<>(Arrays.asList(
				new ArrayList<>(Arrays.asList(1)),
				new ArrayList<>(Arrays.asList(1)),
				new ArrayList<>(Arrays.asList(0)),
				new ArrayList<>(Arrays.asList(1))
			))
		));
	}
}
