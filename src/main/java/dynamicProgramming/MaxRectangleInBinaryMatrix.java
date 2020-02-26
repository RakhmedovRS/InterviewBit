package dynamicProgramming;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
public class MaxRectangleInBinaryMatrix
{
	public int largestRectangleArea(int[] heights)
	{
		int n = heights.length;
		int pos = 0;
		int max = 0;

		Deque<Integer> stack = new LinkedList<>();

		while (pos < n)
		{
			while (!stack.isEmpty() && heights[pos] < heights[stack.peek()])
			{
				max = Math.max(max, heights[stack.pop()] * (pos - (stack.isEmpty() ? 0 : stack.peek() + 1)));
			}
			stack.push(pos++);
		}

		while (!stack.isEmpty())
		{
			max = Math.max(max, heights[stack.pop()] * (n - (stack.isEmpty() ? 0 : stack.peek() + 1)));
		}

		return max;
	}

	public int maximalRectangle(ArrayList<ArrayList<Integer>> matrix)
	{
		int max = 0;
		if (matrix == null || matrix.size() == 0)
		{
			return max;
		}

		int[] histogram = new int[matrix.get(0).size()];
		for (int row = 0; row < matrix.size(); row++)
		{
			for (int column = 0; column < matrix.get(row).size(); column++)
			{
				if (row == 0)
				{
					histogram[column] = matrix.get(row).get(column);
				}
				else
				{
					int current = matrix.get(row).get(column);
					if (current == 0)
					{
						histogram[column] = 0;
					}
					else
					{
						histogram[column] += current;
					}
				}
			}
			max = Math.max(max, largestRectangleArea(histogram));
		}
		return max;

	}
}
