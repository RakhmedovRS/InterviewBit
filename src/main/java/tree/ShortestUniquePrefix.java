package tree;

import java.util.HashMap;

/**
 * @author RakhmedovRS
 * @created 07-Feb-20
 */
public class ShortestUniquePrefix
{
	class Node
	{
		private java.util.Map<Character, Integer> chars;
		private java.util.Map<Character, Node> children;

		public Node()
		{
			chars = new HashMap<>();
			children = new HashMap<>();
		}

		public void addChar(char ch)
		{
			chars.put(ch, chars.getOrDefault(ch, 0) + 1);
			children.put(ch, children.getOrDefault(ch, new Node()));
		}

		public int getCharCount(char ch)
		{
			return chars.get(ch);
		}

		public Node getChild(char ch)
		{
			return children.get(ch);
		}
	}

	public String[] prefix(String[] arr)
	{
		Node root = new Node();
		Node currentLevel;
		for (String word : arr)
		{
			currentLevel = root;
			for (char ch : word.toCharArray())
			{
				currentLevel.addChar(ch);
				currentLevel = currentLevel.getChild(ch);
			}
		}

		String[] res = new String[arr.length];
		int wordPos = 0;
		for (String word : arr)
		{
			currentLevel = root;
			StringBuilder prefix = new StringBuilder();
			for (char ch : word.toCharArray())
			{
				prefix.append(ch);
				if (currentLevel.getCharCount(ch) == 1)
				{
					res[wordPos++] = prefix.toString();
					break;
				}
				else
				{
					currentLevel = currentLevel.getChild(ch);
				}
			}
		}

		return res;
	}
}
