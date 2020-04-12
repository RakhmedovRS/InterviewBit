package arrays;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
public class FindPermutation
{
	public ArrayList<Integer> findPerm(final String A, int B)
	{
		if (A == null || A.length() == 0 || B == 0)
		{
			return new ArrayList<>();
		}

		int min = 1;
		int max = B;

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < A.length(); i++)
		{
			if (A.charAt(i) == 'D')
			{
				result.add(max--);
			}
			else
			{
				result.add(min++);
			}
		}
		result.add(min);

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindPermutation().findPerm("IIID", 5));
	}
}
