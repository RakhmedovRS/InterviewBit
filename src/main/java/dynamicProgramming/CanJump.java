package dynamicProgramming;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 16-Feb-20
 */
public class CanJump
{
	public int canJump(ArrayList<Integer> positions)
	{
		int lastPos = positions.size() - 1;
		for (int i = positions.size() - 1; i >= 0; i--) {
			if (i + positions.get(i) >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0 ? 1 : 0;
	}
}
