package graphs;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 27-Mar-20
 */
public class BlackShapes
{
	public int black(ArrayList<String> A)
	{
		if (A == null || A.size() == 0)
		{
			return 0;
		}

		char[][] grid = new char[A.size()][];
		for (int row = 0; row < A.size(); row++)
		{
			grid[row] = A.get(row).toCharArray();
		}

		int shapes = 0;
		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[row].length; column++)
			{
				if (grid[row][column] == 'X')
				{
					dfs(grid, row, column);
					shapes++;
				}
			}
		}

		return shapes;
	}

	private void dfs(char[][] grid, int row, int column)
	{
		if (row < 0 || column < 0 || row >= grid.length || column >= grid[row].length || grid[row][column] == 'O')
		{
			return;
		}

		grid[row][column] = 'O';

		dfs(grid, row - 1, column);
		dfs(grid, row + 1, column);
		dfs(grid, row, column - 1);
		dfs(grid, row, column + 1);
	}
}
