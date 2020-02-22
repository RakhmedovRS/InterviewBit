package dynamicProgramming;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 22-Feb-20
 */
public class WordBreakII
{
	public ArrayList<String> wordBreak(String s, ArrayList<String> wordDict)
	{
		return wordBreakHelper(s, 0, new HashSet<>(wordDict), new HashMap<>());
	}

	private ArrayList<String> wordBreakHelper(String s, int start, Set<String> dictionary, Map<Integer, ArrayList<String>> memo)
	{
		if (memo.containsKey(start))
		{
			return memo.get(start);
		}

		ArrayList<String> validSubstring = new ArrayList<>();

		if (start == s.length())
		{
			validSubstring.add("");
		}

		for (int end = start + 1; end <= s.length(); end++)
		{
			String prefix = s.substring(start, end);

			if (dictionary.contains(prefix))
			{
				List<String> suffixes = wordBreakHelper(s, end, dictionary, memo);

				for (String suffix : suffixes)
				{
					validSubstring.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
				}
			}
		}
		memo.put(start, validSubstring);
		return memo.get(start);
	}

	public static void main(String[] args)
	{
		System.out.println(new WordBreakII().wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
	}
}
