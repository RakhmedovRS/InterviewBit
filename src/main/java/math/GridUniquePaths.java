package math;

/**
 * @author RakhmedovRS
 * @created 23-Feb-20
 */
public class GridUniquePaths
{
	public int uniquePaths(int m, int n)
	{
		if (m == 0 && n == 0)
		{
			return 1;
		}

		int[][] grid = new int[n][m];
		for (int row = 0; row < n; row++)
		{
			for (int column = 0; column < m; column++)
			{
				if (row == 0)
				{
					grid[row][column] = 1;
				}
				else if (column == 0)
				{
					grid[row][column] = 1;
				}
				else
				{
					grid[row][column] = grid[row - 1][column] + grid[row][column - 1];
				}
			}
		}

		return grid[n - 1][m - 1];
	}
}
