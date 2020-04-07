package dynamicProgramming;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
public class MinSumPathInTriangle
{
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle)
	{
		int rows = triangle.size();
		if (rows == 0)
		{
			return 0;
		}

		int columns = triangle.get(rows - 1).size();
		if (columns == 0)
		{
			return 0;
		}

		int[][] memo = new int[rows][];
		for (int i = 0; i < rows; i++)
		{
			ArrayList<Integer> row = triangle.get(i);
			memo[i] = new int[row.size()];
		}

		memo[0][0] = triangle.get(0).get(0);
		for (int row = 1; row < rows; row++)
		{
			ArrayList<Integer> values = triangle.get(row);
			for (int column = 0; column < values.size(); column++)
			{
				Integer l = leftAdj(memo, row, column);
				Integer r = rightAdj(memo, row, column);
				memo[row][column] = Math.min(l, r) + triangle.get(row).get(column);
			}
		}

		int result = Integer.MAX_VALUE;
		for (int column = 0; column < memo[rows - 1].length; column++)
		{
			result = Math.min(result, memo[rows - 1][column]);
		}
		return result;
	}

	Integer leftAdj(int[][] memo, int row, int column)
	{
		if (row == 0 || column - 1 < 0)
		{
			return Integer.MAX_VALUE;
		}
		return memo[row - 1][column - 1];
	}

	Integer rightAdj(int[][] memo, int row, int column)
	{
		if (row == 0 || column >= memo[row - 1].length)
		{
			return Integer.MAX_VALUE;
		}
		return memo[row - 1][column];
	}
}
