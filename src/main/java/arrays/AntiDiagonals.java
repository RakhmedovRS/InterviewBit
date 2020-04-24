package arrays;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 24-Apr-20
 */
public class AntiDiagonals
{
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> matrix)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (matrix == null || matrix.size() == 0)
		{
			return result;
		}

		int row = 0;
		int column = 0;
		int rows = matrix.size() - 1;
		int columns = matrix.get(0).size() - 1;
		while (row <= rows && column <= columns)
		{
			ArrayList<Integer> diagonal = new ArrayList<>();
			for (int r = row, c = column; r <= rows && c >= 0; r++, c--)
			{
				diagonal.add(matrix.get(r).get(c));
			}

			if (column < columns)
			{
				column++;
			}
			else
			{
				row++;
			}

			result.add(diagonal);
		}

		return result;
	}
}
