package strings;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 21-Apr-20
 */
public class PrettyJson
{
	public ArrayList<String> prettyJSON(String string)
	{
		ArrayList<String> res = new ArrayList<>();
		StringBuilder row = new StringBuilder();
		for (char c : string.toCharArray())
		{
			if (c != ' ')
			{
				row.append(c);
			}
		}
		string = row.toString();
		int N = string.length();
		row = new StringBuilder();
		int t = 0;
		for (int i = 0; i < N; i++)
		{
			char c = string.charAt(i);
			switch (c)
			{
				case '[':
				case '{':
					addLine(res, row);
					addChar(row, t, c);
					addLine(res, row);
					t++;
					break;
				case ']':
				case '}':
					addLine(res, row);
					t--;
					addChar(row, t, c);
					if (i < N - 1 && string.charAt(i + 1) == ',')
					{
						break;
					}
					addLine(res, row);
					break;
				case ',':
					addChar(row, t, c);
					addLine(res, row);
					break;
				default:
					addChar(row, t, c);
					break;
			}
		}
		return res;
	}

	void addChar(StringBuilder row, int t, char c)
	{
		if (row.length() == 0)
		{
			for (int i = 0; i < t; i++)
			{
				row.append('\t');
			}
		}
		row.append(c);
	}

	void addLine(ArrayList<String> result, StringBuilder row)
	{
		if (row.length() > 0)
		{
			result.add(row.toString());
			row.setLength(0);
		}
	}
}
