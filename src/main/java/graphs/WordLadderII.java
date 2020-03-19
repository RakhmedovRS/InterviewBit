package graphs;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 19-Mar-20
 */
public class WordLadderII
{
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
	{
		Set<String> dict = new HashSet<>(wordList);
		Set<String> curWordSet = new HashSet<>();

		//current level word set
		curWordSet.add(beginWord);
		//remove all visited words
		dict.removeAll(curWordSet);

		//map use to mapping the current word to its potential word list
		//hit -> [hot]
		Map<String, List<String>> map = new HashMap<>();

		//result list
		List<List<String>> res = new ArrayList<>();

		//generate a map, which will have the correct mapping for a word to its potentials
		//remember to remove already added words
		while (!curWordSet.isEmpty())
		{
			//already touch the end, no need to expand the map to store any info after end word
			if (curWordSet.contains(endWord))
			{
				break;
			}
			Set<String> nextWordSet = new HashSet<>();
			for (String curWord : curWordSet)
			{
				List<String> potentials = generatePotentials(curWord, dict);
				if (!potentials.isEmpty())
				{
					map.put(curWord, potentials);
					nextWordSet.addAll(potentials);
				}
			}
			dict.removeAll(nextWordSet);
			curWordSet = nextWordSet;
		}

		List<String> temp = new ArrayList<String>();
		//add as there is no entry for begin word inside map
		temp.add(beginWord);
		dfs(res, map, temp, beginWord, endWord);
		return res;
	}

	private void dfs(List<List<String>> res, Map<String, List<String>> map, List<String> temp, String beginWord,
	                 String endWord)
	{
		if (beginWord.equals(endWord))
		{
			res.add(new ArrayList<>(temp));
			return;
		}

		if (map.containsKey(beginWord))
		{
			for (String word : map.get(beginWord))
			{
				temp.add(word);
				dfs(res, map, temp, word, endWord);
				temp.remove(temp.size() - 1);
			}
		}
	}

	// generate potential transformations for current word
	private List<String> generatePotentials(String curWord, Set<String> dict)
	{
		List<String> list = new ArrayList<>();

		char[] wordUnit = curWord.toCharArray();

		for (int i = 0; i < curWord.length(); i++)
		{
			char c = wordUnit[i];
			for (char j = 'a'; j <= 'z'; j++)
			{
				if (c != j)
				{
					wordUnit[i] = j;
					String newWord = new String(wordUnit);
					if (dict.contains(newWord))
					{
						list.add(newWord);
					}
				}
			}
			wordUnit[i] = c;
		}
		return list;
	}
}
