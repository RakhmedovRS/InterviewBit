package stacksAndQueues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author RakhmedovRS
 * @created 11-May-20
 */
public class RedundantBraces
{
	public int braces(String a)
	{
		Stack<Character> stack = new Stack<Character>();
		Set<Character> ops = new HashSet<>(Arrays.asList('(', '+', '-', '*', '/'));
		for (int i = 0; i < a.length(); i++)
		{
			if (ops.contains(a.charAt(i)))
			{
				stack.push(a.charAt(i));
			}
			else if (a.charAt(i) == ')')
			{
				boolean didPopSymbol = false;
				while (stack.peek() != '(')
				{
					didPopSymbol = true;
					stack.pop();
				}
				if (!didPopSymbol)
				{
					return 1;
				}
				stack.pop();
			}
		}
		return 0;
	}
}
