package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
public class OrderOfPeopleHeights
{
	public class Node
	{
		public int start;
		public int end;
		public int space;
		public Node left;
		public Node right;

		public Node(int start, int end)
		{
			this.start = start;
			this.end = end;
			this.space = end - start;
			this.left = null;
			this.right = null;
		}
	}

	public void buildTree(Node node)
	{
		if (node.end - node.start <= 1)
		{
			return;
		}

		int split = (node.start + node.end) / 2;

		node.left = new Node(node.start, split);
		node.right = new Node(split, node.end);

		buildTree(node.left);
		buildTree(node.right);
	}

	public int findPosition(Node node, int inFront)
	{
		node.space -= 1;
		if (node.left == null)
		{
			return node.start;
		}
		if (node.left.space > inFront)
		{
			return findPosition(node.left, inFront);
		}
		else
		{
			return findPosition(node.right, inFront - node.left.space);
		}
	}

	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> inFronts)
	{
		int inputCount = heights.size();

		Node openSpaceTree = new Node(0, inputCount);
		buildTree(openSpaceTree);

		HashMap<Integer, Integer> heightMap = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>(inputCount);

		for (int i = 0; i < heights.size(); i++)
		{
			heightMap.put(heights.get(i), inFronts.get(i));
			result.add(null);
		}

		Collections.sort(heights);

		for (Integer height : heights)
		{
			int numberInFront = heightMap.get(height);
			int openPosition = findPosition(openSpaceTree, numberInFront);
			result.set(openPosition, height);
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new OrderOfPeopleHeights()
			.order(new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 4)),
				new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 2))));
	}
}

