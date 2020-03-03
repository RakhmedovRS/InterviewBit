package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 03-Mar-20
 */
public class NextPermutation
{
	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A)
	{
		Integer[] nums = A.toArray(new Integer[]{});
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i])
		{
			i--;
		}
		if (i >= 0)
		{
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i])
			{
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);

		return new ArrayList<>(Arrays.asList(nums));
	}

	private void reverse(Integer[] nums, int start)
	{
		int i = start, j = nums.length - 1;
		while (i < j)
		{
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(Integer[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
