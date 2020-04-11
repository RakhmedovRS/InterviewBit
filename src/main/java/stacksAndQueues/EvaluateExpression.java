package stacksAndQueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
public class EvaluateExpression
{
	public int evalRPN(ArrayList<String> tokens)
	{
		Deque<Integer> values = new LinkedList<>();
		for (String token : tokens)
		{
			switch (token)
			{
				case "+":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(a + b);
					break;
				}
				case "-":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(b - a);
					break;
				}
				case "*":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(a * b);
					break;
				}
				case "/":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(b / a);
					break;
				}
				default:
				{
					values.addLast(Integer.parseInt(token));
					break;
				}
			}
		}

		return values.getLast();
	}
}
