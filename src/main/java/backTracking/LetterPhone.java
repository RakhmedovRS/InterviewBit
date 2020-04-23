package backTracking;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 23-Apr-20
 */
public class LetterPhone
{
	private Map<Character, List<Character>> getDictionary()
	{
		Map<Character, List<Character>> dictionary = new HashMap<>();
		dictionary.put('0', Collections.singletonList('0'));
		dictionary.put('1', Collections.singletonList('1'));
		dictionary.put('2', Arrays.asList('a', 'b', 'c'));
		dictionary.put('3', Arrays.asList('d', 'e', 'f'));
		dictionary.put('4', Arrays.asList('g', 'h', 'i'));
		dictionary.put('5', Arrays.asList('j', 'k', 'l'));
		dictionary.put('6', Arrays.asList('m', 'n', 'o'));
		dictionary.put('7', Arrays.asList('p', 'q', 'r', 's'));
		dictionary.put('8', Arrays.asList('t', 'u', 'v'));
		dictionary.put('9', Arrays.asList('w', 'x', 'y', 'z'));
		return dictionary;
	}

	public ArrayList<String> letterCombinations(String digits)
	{
		if (digits == null || digits.length() == 0)
		{
			return new ArrayList<>();
		}
		LinkedList<StringBuilder> builderList = new LinkedList<>();
		Map<Character, List<Character>> dictionary = getDictionary();
		char[] chars = digits.toCharArray();
		for (Character ch : dictionary.get(chars[0]))
		{
			builderList.add(new StringBuilder("" + ch));
		}

		for (int i = 1; i < chars.length; i++)
		{
			int size = builderList.size();
			while (size > 0)
			{
				StringBuilder builder = builderList.removeFirst();
				for (Character ch : dictionary.get(chars[i]))
				{
					StringBuilder newBuilder = new StringBuilder(builder);
					newBuilder.append(ch);
					builderList.addLast(newBuilder);
				}

				size--;
			}
		}

		return builderList.stream().map(StringBuilder::toString).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
	}
}
