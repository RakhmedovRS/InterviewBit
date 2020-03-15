package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
public class MaxSumWithoutAdjacentElements
{
	public int adjacent(ArrayList<ArrayList<Integer>> values)
	{
		if (values == null || values.size() == 0)
		{
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int columns = values.get(0).size();
		int rows = values.size();
		int[][] memo = new int[rows][columns];

		for (int column = 0; column < columns; column++)
		{
			for (int row = 0; row < rows; row++)
			{
				int value = values.get(row).get(column);
				if (column < 2)
				{
					memo[row][column] = value;
				}
				else
				{
					int row1 = memo[0][column - 2];
					int row2 = memo[1][column - 2];
					if (column - 2 == 0)
					{
						memo[row][column] = Math.max(value, Math.max(value + row1, value + row2));
					}
					else
					{
						int row1col2 = memo[0][column - 3];
						int row2col2 = memo[1][column - 3];
						memo[row][column] = Math.max(value,
							Math.max(
								Math.max(value + row1, value + row2),
								Math.max(value + row1col2, value + row2col2)
							));
					}
				}

				max = Math.max(max, memo[row][column]);
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> a0 = new ArrayList<>();
		a0.add(new ArrayList<>(Arrays.asList(4, 4, 3, 3, 20, 10, 7, 3, 15, 20, 8, 17, 14, 19)));
		a0.add(new ArrayList<>(Arrays.asList(7, 18, 20, 9, 8, 13, 7, 16, 14, 7, 9, 1, 8, 17)));
		System.out.println(new MaxSumWithoutAdjacentElements().adjacent(a0));

		ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
		a1.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		a1.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
		System.out.println(new MaxSumWithoutAdjacentElements().adjacent(a1));

		ArrayList<ArrayList<Integer>> a2 = new ArrayList<>();
		a2.add(new ArrayList<>(Arrays.asList(1)));
		a2.add(new ArrayList<>(Arrays.asList(2)));
		System.out.println(new MaxSumWithoutAdjacentElements().adjacent(a2));

		ArrayList<ArrayList<Integer>> a3 = new ArrayList<>();
		a3.add(new ArrayList<>(Arrays.asList(-1, -2)));
		a3.add(new ArrayList<>(Arrays.asList(-3, -4)));
		System.out.println(new MaxSumWithoutAdjacentElements().adjacent(a3));

		ArrayList<ArrayList<Integer>> a4 = new ArrayList<>();
		a4.add(new ArrayList<>(Arrays.asList(16, 5, 54, 55, 36, 82, 61, 77, 66, 61)));
		a4.add(new ArrayList<>(Arrays.asList(31, 30, 36, 70, 9, 37, 1, 11, 68, 14)));
		System.out.println(new MaxSumWithoutAdjacentElements().adjacent(a4));
	}
}
