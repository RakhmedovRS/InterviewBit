package greedyAlgorithm;

/**
 * @author RakhmedovRS
 * @created 05-Mar-20
 */
public class Seats
{
	public int findMedian(String a)
	{
		int medianIndex = 0;
		for (int i = 0; i < a.length(); i++)
		{
			if (a.charAt(i) == 'x')
			{
				medianIndex++;
			}
		}

		if (medianIndex == 0)
		{
			return -1;
		}

		medianIndex = (medianIndex + 1) / 2;

		int medianValue = -1;
		int medianCounter = 0;
		for (int i = 0; i < a.length(); i++)
		{

			if (a.charAt(i) == 'x')
			{
				medianCounter++;
				if (medianCounter == medianIndex)
				{
					medianValue = i;
					break;
				}
			}
		}

		return medianValue;
	}

	public int shiftElements(char[] values, int medianIndex)
	{

		int leftBound = 0;
		int rightBound = medianIndex;
		long count = 0;

		while (leftBound < rightBound)
		{

			if (values[leftBound] == '.')
			{
				leftBound++;
			}

			else if (values[rightBound] == 'x')
			{
				rightBound--;
			}
			else
			{
				values[rightBound] = values[leftBound];
				values[leftBound] = '.';
				count += rightBound - leftBound;
				leftBound++;
				rightBound--;
			}
		}

		leftBound = medianIndex;
		rightBound = values.length - 1;

		while (leftBound < rightBound)
		{
			if (values[leftBound] == 'x')
			{
				leftBound++;
			}
			else if (values[rightBound] == '.')
			{
				rightBound--;
			}
			else
			{
				values[leftBound] = values[rightBound];
				values[rightBound] = '.';
				count += rightBound - leftBound;
				leftBound++;
				rightBound--;
			}
		}

		return (int) (count % 10000003);
	}

	public int seats(String a)
	{

		int medianIndex = findMedian(a);

		if (medianIndex == -1)
		{
			return 0;
		}

		return shiftElements(a.toCharArray(), medianIndex);
	}
}
