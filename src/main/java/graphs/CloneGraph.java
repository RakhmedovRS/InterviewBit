package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
public class CloneGraph
{
	class UndirectedGraphNode
	{
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x)
		{
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
	{
		if (node == null)
		{
			return null;
		}

		Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

		return cloneGraph(node, visited);
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> visited)
	{
		if (node == null)
		{
			return null;
		}

		UndirectedGraphNode newNode = visited.get(node);
		if (newNode != null)
		{
			return newNode;
		}

		newNode = new UndirectedGraphNode(node.label);
		visited.put(node, newNode);

		for (UndirectedGraphNode neighbor : node.neighbors)
		{
			newNode.neighbors.add(cloneGraph(neighbor, visited));
		}

		return newNode;
	}
}
