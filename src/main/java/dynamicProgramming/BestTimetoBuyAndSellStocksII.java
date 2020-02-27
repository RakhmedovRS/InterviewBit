package dynamicProgramming;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 27-Feb-20
 */
public class BestTimetoBuyAndSellStocksII
{
	public int maxProfit(final List<Integer> prices)
	{
		int maxProfit = 0;
		if (prices == null || prices.size() <= 1)
		{
			return maxProfit;
		}
		int buyDay = 0;
		for (int currentDay = 1; currentDay < prices.size(); currentDay++)
		{
			if (prices.get(currentDay) >= prices.get(currentDay - 1))
			{
				if (currentDay + 1 == prices.size())
				{
					maxProfit += prices.get(currentDay) - prices.get(buyDay);
				}
			}
			else
			{
				maxProfit += prices.get(currentDay - 1) - prices.get(buyDay);
				buyDay = currentDay;
			}
		}
		return maxProfit;
	}
}
