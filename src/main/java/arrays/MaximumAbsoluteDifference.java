package arrays;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 08-May-20
 */
public class MaximumAbsoluteDifference
{
	public int maxArr(ArrayList<Integer> A) {
		int n = A.size();
		int max_sum = A.get(0);
		int min_sum = A.get(0);
		int max_diff = -A.get(0);
		int min_diff = -A.get(0);
		for (int i = 1; i < n; i++) {
			max_sum = Math.max(max_sum, A.get(i) + i);
			min_sum = Math.min(min_sum, A.get(i) + i);
			max_diff = Math.max(max_diff, i - A.get(i));
			min_diff = Math.min(min_diff, i - A.get(i));
		}

		return Math.max(max_sum - min_sum, max_diff - min_diff);
	}
}
