package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 18-Apr-20
 */
public class MinJumpsArray
{
	public int jump(ArrayList<Integer> A)
	{
		if (A.size() == 1)
		{
			return 0;
		}
		int jumps = 1;
		int lastReach = A.get(0);
		int maxReach = A.get(0);
		for (int i = 1; i < A.size(); i++)
		{
			if (maxReach < i)
			{
				return -1;
			}
			if (lastReach < i)
			{
				jumps++;
				lastReach = maxReach;
			}
			maxReach = Math.max(maxReach, i + A.get(i));
		}
		return jumps;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinJumpsArray().jump(new ArrayList<>(Arrays.asList(
			33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4,
			12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35,
			4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39,
			0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11,
			24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0,
			42, 15, 25, 0, 41, 2, 48, 28))));
		System.out.println(new MinJumpsArray().jump(new ArrayList<>(Arrays.asList(10, 1, 1, 1, 1, 1, 1, 1, 1))));
		System.out.println(new MinJumpsArray().jump(new ArrayList<>(Arrays.asList(2, 1, 1))));
		System.out.println(new MinJumpsArray().jump(new ArrayList<>(Arrays.asList(2, 3, 1, 1, 4))));
	}
}
