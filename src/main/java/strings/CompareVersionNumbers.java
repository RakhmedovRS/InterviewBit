package strings;

import java.math.BigInteger;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
public class CompareVersionNumbers
{
	public int compareVersion(String a, String b)
	{
		int i = 0, j = 0;
		while (i < a.length() || j < b.length())
		{
			StringBuilder sa = new StringBuilder("0");
			StringBuilder sb = new StringBuilder("0");
			while (i < a.length() && a.charAt(i) != '.')
			{
				sa.append(a.charAt(i));
				i += 1;
			}
			while (j < b.length() && b.charAt(j) != '.')
			{
				sb.append(b.charAt(j));
				j += 1;
			}
			BigInteger a1 = new BigInteger(sa.toString());
			BigInteger b1 = new BigInteger(sb.toString());
			if (!a1.equals(b1))
			{
				return a1.compareTo(b1);
			}
			i += 1;
			j += 1;
		}
		return 0;
	}
}
