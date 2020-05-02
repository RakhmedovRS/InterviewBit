package dynamicProgramming;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
public class ScrambleString
{
	public int isScramble(final String s1, final String s2)
	{
		if (s1.equals(s2))
		{
			return 1;
		}

		if (!containTheSameChars(s1, s2))
		{
			return 0;
		}

		for (int i = 1; i < s1.length(); i++)
		{
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) == 1
				&& isScramble(s1.substring(i), s2.substring(i)) == 1)
			{
				return 1;
			}

			if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) == 1
				&& isScramble(s1.substring(i), s2.substring(0, s1.length() - i)) == 1)
			{
				return 1;
			}
		}

		return 0;
	}

	private boolean containTheSameChars(String s1, String s2)
	{
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] s1Chars = new int[26];
		int[] s2Chars = new int[26];
		for (char ch : s1.toCharArray())
		{
			s1Chars[ch - 'a']++;
		}

		for (char ch : s2.toCharArray())
		{
			s2Chars[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++)
		{
			if (s1Chars[i] != s2Chars[i])
			{
				return false;
			}
		}

		return true;
	}
}
