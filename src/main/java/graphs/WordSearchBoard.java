package graphs;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 22-Mar-20
 */
public class WordSearchBoard
{
	public int exist(ArrayList<String> board, String word)
	{
		if (board == null || word == null)
		{
			return 0;
		}

		for (int row = 0; row < board.size(); row++)
		{
			for (int column = 0; column < board.get(row).length(); column++)
			{
				if (exist(board, row, column, word, 0))
				{
					return 1;
				}
			}
		}
		return 0;
	}

	private boolean exist(ArrayList<String> board, int row, int column, String word, int start)
	{
		if (start >= word.length())
		{
			return true;
		}
		if (row < 0 || row >= board.size() || column < 0 || column >= board.get(0).length())
		{
			return false;
		}

		if (board.get(row).charAt(column) == word.charAt(start++))
		{
			return exist(board, row + 1, column, word, start)
				|| exist(board, row - 1, column, word, start)
				|| exist(board, row, column + 1, word, start)
				|| exist(board, row, column - 1, word, start);
		}
		return false;
	}
}
