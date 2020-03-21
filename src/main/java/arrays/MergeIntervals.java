package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 21-Mar-20
 */
public class MergeIntervals
{
	public static class Interval
	{
		int start;
		int end;

		Interval(int s, int e)
		{
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
	{
		ArrayList<Interval> answer = new ArrayList<>();
		for (Interval interval : intervals)
		{
			if (newInterval.end < interval.start)
			{
				answer.add(newInterval);
				newInterval = interval;
			}
			else if (newInterval.start <= interval.end)
			{
				newInterval = new Interval(Math.min(newInterval.start, interval.start), Math.max(newInterval.end, interval.end));
			}
			else
			{
				answer.add(interval);
			}
		}

		answer.add(newInterval);
		return answer;
	}

	public static void main(String[] args)
	{
		new MergeIntervals().insert(
			new ArrayList<>(
				Arrays.asList(
					new Interval(1, 2),
					new Interval(3, 5),
					new Interval(6, 7),
					new Interval(8, 10),
					new Interval(12, 16)
				)
			),
			new Interval(-1, 0)
		).forEach(arr -> System.out.print(arr.start + "," + arr.end + " "));

		System.out.println();

		new MergeIntervals().insert(
			new ArrayList<>(
				Arrays.asList(
					new Interval(1, 2),
					new Interval(3, 5),
					new Interval(6, 7),
					new Interval(8, 10),
					new Interval(12, 16)
				)
			),
			new Interval(4, 9)
		).forEach(arr -> System.out.print(arr.start + "," + arr.end + " "));

		System.out.println();

		new MergeIntervals().insert(
			new ArrayList<>(
				Arrays.asList(
					new Interval(1, 2),
					new Interval(3, 5),
					new Interval(6, 7),
					new Interval(8, 10),
					new Interval(12, 16)
				)
			),
			new Interval(17, 18)
		).forEach(arr -> System.out.print(arr.start + "," + arr.end + " "));
	}
}
