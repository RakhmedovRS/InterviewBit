package strings;

/**
 * @author RakhmedovRS
 * @created 24-Mar-20
 */
public class MinimumCharactersRequiredToMakeStringPalindromic
{
	void computeLPS(String s, int[] lps)
	{
		int left = 0;
		int right = 1;
		while (right < s.length())
		{
			if (s.charAt(right) == s.charAt(left))
			{
				left++;
				lps[right] = left;
				right++;
			}
			else
			{
				if (left != 0)
				{
					left = lps[left - 1];
				}
				else
				{
					lps[right] = 0;
					right++;
				}
			}
		}
	}

	public int solve(String a)
	{
		StringBuilder s = new StringBuilder(a);
		String str = a + "$" + s.reverse().toString();
		int[] lps = new int[str.length()];
		computeLPS(str, lps);
		return (a.length() - lps[str.length() - 1]);
	}
}
