package dynamicProgramming;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 20-Feb-20
 */
public class BestTimeToBuyAndSellStocksI
{
	public int maxProfit(List<Integer> prices)
	{
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price : prices)
		{
			if (minPrice > price)
			{
				minPrice = price;
			}
			else if (price - minPrice > profit)
			{
				profit = price - minPrice;
			}
		}

		return profit;
	}
}
