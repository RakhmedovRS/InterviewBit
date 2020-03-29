package dynamicProgramming;

/**
 * @author RakhmedovRS
 * @created 29-Mar-20
 */
public class RegularExpressionMatch
{
	public int isMatch(String s, String p)
	{
		if (s == null && p == null)
		{
			return 1;
		}
		else if (s != null && s.length() == 0 && p != null && p.length() == 0)
		{
			return 1;
		}
		else if (s == null || p == null)
		{
			return 0;
		}

		char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();
		int currentPos = 0;
		boolean firstStar = true;
		for (int pos = 0; pos < pattern.length; pos++)
		{
			if (pattern[pos] == '*')
			{
				if (firstStar)
				{
					pattern[currentPos++] = pattern[pos];
					firstStar = false;
				}
			}
			else
			{
				pattern[currentPos++] = pattern[pos];
				firstStar = true;
			}
		}

		boolean[][] memo = new boolean[string.length + 1][currentPos + 1];
		memo[0][0] = true;
		if (currentPos > 0 && pattern[0] == '*')
		{
			memo[0][1] = true;
		}

		for (int row = 1; row < memo.length; row++)
		{
			for (int column = 1; column < memo[row].length; column++)
			{
				char ch = pattern[column - 1];
				if (ch == '?' || string[row - 1] == ch)
				{
					memo[row][column] = memo[row - 1][column - 1];
				}
				else if (ch == '*')
				{
					memo[row][column] = memo[row - 1][column] || memo[row][column - 1];
				}
				else
				{
					memo[row][column] = false;
				}
			}
		}

		return memo[string.length][currentPos] ? 1 : 0;
	}
}
