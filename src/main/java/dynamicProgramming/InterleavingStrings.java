package dynamicProgramming;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
public class InterleavingStrings
{
	public int isInterleave(String A, String B, String C)
	{
		if (A.length() + B.length() != C.length())
		{
			return 0;
		}

		boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
		for (int i = 0; i <= A.length(); i++)
		{
			for (int j = 0; j <= B.length(); j++)
			{
				if (i == 0 && j == 0)
				{
					dp[i][j] = true;
					continue;
				}
				dp[i][j] = (i > 0 && A.charAt(i - 1) == C.charAt(i + j - 1) && dp[i - 1][j])
					|| (j > 0 && B.charAt(j - 1) == C.charAt(i + j - 1) && dp[i][j - 1]);
			}
		}
		return dp[A.length()][B.length()] ? 1 : 0;
	}
}
