package graphs;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
public class SumOfFibonacciNumbers
{
	public int fibsum(int n)
	{
		if (n <= 1)
		{
			return n;
		}

		int a = 1;
		int b = 1;
		int c = 1;
		int temp;
		while (b + c < n)
		{
			temp = b + c;
			a = b;
			b = c;
			c = temp;
		}

		return 1 + fibsum(n - (a + b));
	}
}
