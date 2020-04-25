package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 25-Apr-20
 */
public class ValidIpAddresses
{
	public ArrayList<String> restoreIpAddresses(String string)
	{
		ArrayList<String> result = new ArrayList<>();
		restoreIpAddresses(string, 0, result, new LinkedList<>());
		return result;
	}

	private void restoreIpAddresses(String string, int currentPos, List<String> result, LinkedList<String> current)
	{
		if (string.length() < 4)
		{
			return;
		}

		if (currentPos >= string.length() && current.size() == 4)
		{
			result.add(String.join(".", current));
			return;
		}

		if (current.size() == 4)
		{
			return;
		}

		for (int i = currentPos + 1; i <= currentPos + 3 && i <= string.length(); i++)
		{
			String sub = string.substring(currentPos, i);
			if ((sub.length() > 1 && sub.charAt(0) == '0') || Integer.parseInt(sub) > 255)
			{
				return;
			}
			current.addLast(sub);
			restoreIpAddresses(string, i, result, current);
			current.removeLast();
		}
	}
}
