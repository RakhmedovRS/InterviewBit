package greedyAlgorithm;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 29-Feb-20
 */
public class Bulbs
{
	public int bulbs(ArrayList<Integer> A)
	{
		int switchesPressed = 0;
		for (int state : A)
		{
			if (state == 0 && switchesPressed % 2 == 0)
			{
				switchesPressed++;
			}
			else if (state == 1 && switchesPressed % 2 != 0)
			{
				switchesPressed++;
			}
		}

		return switchesPressed;
	}
}
