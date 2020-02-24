package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
public class UniquePathsInGrid
{
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> obstacles)
	{
		if (obstacles == null || obstacles.size() == 0)
		{
			return 0;
		}

		if (obstacles.get(0).get(0) == 1)
		{
			return 0;
		}

		int[][] grid = new int[obstacles.size()][obstacles.get(0).size()];
		grid[0][0] = 1;
		for (int row = 1; row < obstacles.size(); row++)
		{
			grid[row][0] = obstacles.get(row).get(0) == 1 ? 0 : grid[row - 1][0];
		}

		for (int column = 1; column < obstacles.get(0).size(); column++)
		{
			grid[0][column] = obstacles.get(0).get(column) == 1 ? 0 : grid[0][column - 1];
		}

		for (int row = 1; row < obstacles.size(); row++)
		{
			for (int column = 1; column < obstacles.get(0).size(); column++)
			{
				grid[row][column] = obstacles.get(row).get(column) == 1 ? 0 : grid[row - 1][column] + grid[row][column - 1];
			}
		}

		return grid[obstacles.size() - 1][obstacles.get(0).size() - 1];
	}

	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> obstacles = new ArrayList<>();
		obstacles.add(new ArrayList<>(Arrays.asList(0,0)));
		System.out.println(new UniquePathsInGrid().uniquePathsWithObstacles(obstacles));
	}
}
