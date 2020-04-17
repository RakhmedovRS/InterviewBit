package backTracking;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 17-Apr-20
 */
public class PalindromePartitioning
{
	public ArrayList<ArrayList<String>> partition(String string)
	{
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (string == null || string.length() == 0)
		{
			return result;
		}

		ArrayList<String> current = new ArrayList<>();
		palindrome(string, 0, current, result);
		return result;
	}

	private void palindrome(String string, int currentPos, ArrayList<String> current, ArrayList<ArrayList<String>> result)
	{
		if (currentPos >= string.length())
		{
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = 1; i + currentPos <= string.length(); i++)
		{
			String subString = string.substring(currentPos, currentPos + i);
			if (isPalindrome(subString))
			{
				current.add(subString);
				palindrome(string, currentPos + i, current, result);
				current.remove(current.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String string)
	{
		int left = 0;
		int right = string.length() - 1;
		while (left <= right)
		{
			if (string.charAt(left) != string.charAt(right))
			{
				return false;
			}
			left++;
			right--;
		}

		return true;
	}
}
