package binarySearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author RakhmedovRS
 * @created 15-Apr-20
 */
public class MatrixMedian
{
	public int findMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		int rows = matrix.size();
		if (rows == 0)
		{
			return 0;
		}
		int columns = matrix.get(0).size();
		if (columns == 0)
		{
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (ArrayList<Integer> row : matrix)
		{
			if (min > row.get(0))
			{
				min = row.get(0);
			}

			if (max < row.get(columns - 1))
			{
				max = row.get(columns - 1);
			}
		}

		int middleCount = (rows * columns + 1) / 2;
		int median;
		int count;
		int idx;
		while (min < max)
		{
			median = min + (max - min) / 2;
			count = 0;

			for (ArrayList<Integer> integers : matrix)
			{
				idx = Collections.binarySearch(integers, median);
				if (idx < 0)
				{
					idx = Math.abs(idx) - 1;
				}
				else
				{
					while (idx < columns && integers.get(idx) == median)
					{
						idx += 1;
					}
				}
				count += idx;
			}

			if (count < middleCount)
			{
				min = median + 1;
			}
			else
			{
				max = median;
			}
		}
		return min;
	}
}
