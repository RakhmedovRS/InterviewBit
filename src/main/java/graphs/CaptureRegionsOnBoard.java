package graphs;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 23-Mar-20
 */
public class CaptureRegionsOnBoard
{
	final char X = 'X';
	final char O = 'O';
	final char V = 'V';
	int ROW;
	int COLUMN;

	public void solve(ArrayList<ArrayList<Character>> a)
	{
		ROW = a.size();
		COLUMN = a.get(0).size();
		for (int row = 0; row < ROW; row++)
		{
			for (int column = 0; column < COLUMN; column++)
			{
				if (row == 0 || row == ROW - 1 || column == 0 || column == COLUMN - 1)
				{
					dfs(a, row, column);
				}
			}
		}

		for (int row = 0; row < ROW; row++)
		{
			ArrayList<Character> values = a.get(row);
			for (int j = 0; j < COLUMN; j++)
			{
				char c = values.get(j);
				switch (c)
				{
					case O:
					{
						values.set(j, X);
						break;
					}
					case V:
					{
						values.set(j, O);
						break;
					}
				}
			}
		}
	}

	void dfs(ArrayList<ArrayList<Character>> a, int row, int column)
	{
		if (row < 0 || row > ROW - 1 || column < 0 || column > COLUMN - 1)
		{
			return;
		}
		char c = a.get(row).get(column);
		switch (c)
		{
			case X:
			case V:
				return;
		}
		a.get(row).set(column, V);
		dfs(a, row - 1, column);
		dfs(a, row + 1, column);
		dfs(a, row, column - 1);
		dfs(a, row, column + 1);
	}
}