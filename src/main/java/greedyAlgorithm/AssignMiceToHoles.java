package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author RakhmedovRS
 * @created 07-Mar-20
 */
public class AssignMiceToHoles
{
	public int mice(ArrayList<Integer> mouses, ArrayList<Integer> holes)
	{
		Collections.sort(mouses);
		Collections.sort(holes);
		int result = 0;
		for (int i = 0; i < mouses.size(); i++)
		{
			result = Math.max(result, Math.abs(mouses.get(i) - holes.get(i)));
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new AssignMiceToHoles().mice(new ArrayList<>(Arrays.asList(4, -4, 2)), new ArrayList<>(Arrays.asList(4, 0, 5))));
	}
}
