package dynamicProgramming;

/**
 * @author RakhmedovRS
 * @created 09-Apr-20
 */
public class WaysToColor3xNBoard
{
	public int solve(int A)
	{
		long color3 = 24;
		long color2 = 12;
		long temp;
		for (int i = 2; i <= A; i++)
		{
			temp = color3;
			color3 = (11 * color3 + 10 * color2) % 1000000007;
			color2 = (5 * temp + 7 * color2) % 1000000007;
		}
		long num = (color3 + color2) % 1000000007;
		return (int) num;
	}
}
