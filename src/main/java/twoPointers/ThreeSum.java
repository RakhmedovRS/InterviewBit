package twoPointers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author RakhmedovRS
 * @created 25-Mar-20
 */
public class ThreeSum
{
	public int threeSumClosest(ArrayList<Integer> A, int B)
	{
		if (A == null || A.size() < 3)
		{
			return 0;
		}
		long result = Integer.MAX_VALUE - B;
		int first, second, third;
		Collections.sort(A);
		int size = A.size();
		for (int pivot = 0; pivot < size; pivot++)
		{
			first = A.get(pivot);
			int left = 0;
			if (left == pivot)
			{
				left++;
			}
			int right = size - 1;
			if (right == pivot)
			{
				right--;
			}
			while (left < size && right >= 0 && left < right)
			{
				second = A.get(left);
				third = A.get(right);
				long sum = first + second + third;
				if (Math.abs(B - sum) < Math.abs(B - result))
				{
					result = sum;
				}
				if (sum < B)
				{
					left++;
					if (left == pivot)
					{
						left++;
					}
				}
				else
				{
					right--;
					if (right == pivot)
					{
						right--;
					}
				}
			}
		}
		return (int) result;
	}
}
