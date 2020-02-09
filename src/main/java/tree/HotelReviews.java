package tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 09-Feb-20
 */
public class HotelReviews
{
	class Trie
	{
		private Node root;

		class Node
		{
			private Map<Character, Node> children;
			boolean isEnd;

			public Node()
			{
				children = new HashMap<>();
			}

			public Map<Character, Node> getChildren()
			{
				return children;
			}

			public boolean isEnd()
			{
				return isEnd;
			}

			public void setEnd()
			{
				isEnd = true;
			}
		}

		public Trie()
		{
			this.root = new Node();
		}

		public Node addWord(String word)
		{
			Node current = root;
			for (int i = 0; i < word.length(); i++)
			{
				char ch = word.charAt(i);
				current.getChildren().put(ch, current.getChildren().getOrDefault(ch, new Node()));
				current = current.getChildren().get(ch);
			}
			current.setEnd();

			return current;
		}

		public boolean contains(String word)
		{
			Node current = root;
			for (int i = 0; i < word.length() && current != null; i++)
			{
				current = current.getChildren().get(word.charAt(i));
			}

			return current != null && current.isEnd();
		}
	}

	public ArrayList<Integer> solve(String A, ArrayList<String> B)
	{
		Trie trie = new Trie();
		for (String word : A.split("_"))
		{
			trie.addWord(word);
		}

		List<Map.Entry<String, Integer>> entries = new ArrayList<>();

		for (int i = 0; i < B.size(); i++)
		{
			entries.add(new AbstractMap.SimpleEntry<>(B.get(i), i));
		}

		entries.sort((val1, val2) -> {
			Integer val1Count = 0;
			for (String word : val1.getKey().split("_"))
			{
				if (trie.contains(word))
				{
					val1Count++;
				}
			}

			Integer val2Count = 0;
			for (String word : val2.getKey().split("_"))
			{
				if (trie.contains(word))
				{
					val2Count++;
				}
			}

			return val2Count.compareTo(val1Count);
		});

		return entries.stream().map(Map.Entry::getValue).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
	}

	public static void main(String[] args)
	{
		HotelReviews hotelReviews = new HotelReviews();
		System.out.println(hotelReviews.solve("cool_ice_wifi", new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
	}
}
