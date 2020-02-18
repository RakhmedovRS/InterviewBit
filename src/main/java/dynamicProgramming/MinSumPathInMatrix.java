package dynamicProgramming;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 18-Feb-20
 */
public class MinSumPathInMatrix
{
	public int minPathSum(ArrayList<ArrayList<Integer>> A)
	{
		if (A == null || A.size() == 0)
		{
			return 0;
		}

		int[][] grid = new int[A.size()][A.get(0).size()];
		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[row].length; column++)
			{
				grid[row][column] = A.get(row).get(column);
			}
		}

		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[row].length; column++)
			{
				if (row > 0 && column > 0)
				{
					grid[row][column] += Math.min(grid[row - 1][column], grid[row][column - 1]);
				}
				else if (row > 0)
				{
					grid[row][column] += grid[row - 1][column];
				}
				else if (column > 0)
				{
					grid[row][column] += grid[row][column - 1];
				}
			}
		}

		return grid[grid.length - 1][grid[0].length - 1];
	}
}
