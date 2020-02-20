package dynamicProgramming;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 20-Feb-20
 */
public class WordBreak
{
	public int wordBreak(String s, ArrayList<String> wordDict)
	{
		return dsf(s, new HashSet<>(wordDict), new HashMap<>()) ? 1 : 0;
	}

	private boolean dsf(String s, Set<String> dictionary, Map<String, Boolean> cache)
	{
		if (s.equals(""))
		{
			return true;
		}

		if (cache.containsKey(s))
		{
			return cache.get(s);
		}

		for (int i = 0; i <= s.length(); i++)
		{
			if (dictionary.contains(s.substring(0, i)) && dsf(s.substring(i), dictionary, cache))
			{
				cache.put(s.substring(i), true);
				return true;
			}
		}

		cache.put(s, false);
		return false;
	}
}
