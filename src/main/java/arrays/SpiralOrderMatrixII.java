package arrays;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 01-Mar-20
 */
public class SpiralOrderMatrixII
{
	enum Direction
	{
		RIGHT,
		DOWN,
		LEFT,
		UP
	}

	public ArrayList<ArrayList<Integer>> generateMatrix(int n)
	{
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(n);
		if (n == 0)
		{
			return matrix;
		}
		ArrayList<Integer> tempo = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
		{
			tempo.add(0);
		}
		for (int i = 0; i < n; i++)
		{
			matrix.add(new ArrayList<>(tempo));
		}

		int actualValue = 1;
		Direction currentDirection = Direction.RIGHT;
		int leftEdge = 0;
		int rightEdge = n - 1;
		int upperEdge = 0;
		int bottomEdge = n - 1;
		while (leftEdge <= rightEdge && upperEdge <= bottomEdge)
		{
			switch (currentDirection)
			{
				case RIGHT:
				{
					for (int i = leftEdge; i <= rightEdge; i++)
					{
						matrix.get(upperEdge).set(i, actualValue++);
					}
					currentDirection = Direction.DOWN;
					upperEdge++;
					break;
				}
				case DOWN:
				{
					for (int i = upperEdge; i <= bottomEdge; i++)
					{
						matrix.get(i).set(rightEdge, actualValue++);
					}
					currentDirection = Direction.LEFT;
					rightEdge--;
					break;
				}
				case LEFT:
				{
					for (int i = rightEdge; i >= leftEdge; i--)
					{
						matrix.get(bottomEdge).set(i, actualValue++);
					}
					currentDirection = Direction.UP;
					bottomEdge--;
					break;
				}
				case UP:
				{
					for (int i = bottomEdge; i >= upperEdge; i--)
					{
						matrix.get(i).set(leftEdge, actualValue++);
					}
					currentDirection = Direction.RIGHT;
					leftEdge++;
					break;
				}
			}
		}

		return matrix;
	}

	public static void main(String[] args)
	{
		System.out.println(new SpiralOrderMatrixII().generateMatrix(0));
		System.out.println(new SpiralOrderMatrixII().generateMatrix(1));
		System.out.println(new SpiralOrderMatrixII().generateMatrix(2));
		System.out.println(new SpiralOrderMatrixII().generateMatrix(3));
	}
}
