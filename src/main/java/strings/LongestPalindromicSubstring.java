package strings;

/**
 * @author RakhmedovRS
 * @created 16-Apr-20
 */
public class LongestPalindromicSubstring
{
	public String longestPalindrome(String s)
	{
		if (s == null || s.length() == 0)
		{
			return "";
		}

		char[] chars = s.toCharArray();
		int start = 0;
		int end = 0;
		int maxLength;
		for (int center = 0; center < s.length(); center++)
		{
			int odd = checkAroundTheCenter(chars, center, center);
			int even = checkAroundTheCenter(chars, center, center + 1);
			maxLength = Math.max(odd, even);
			if (maxLength > end - start)
			{
				start = center - (maxLength - 1) / 2;
				end = center + maxLength / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	private int checkAroundTheCenter(char[] chars, int left, int right)
	{
		while (left >= 0 && right < chars.length && chars[left] == chars[right])
		{
			left--;
			right++;
		}

		return right - left - 1;
	}
}
