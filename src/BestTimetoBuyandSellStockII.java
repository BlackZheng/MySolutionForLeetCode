
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < buyingPrice)//it means we can buy the stock.
                buyingPrice = prices[i];
            else{//it means we can sell the stock
                profit += prices[i] - buyingPrice;
                buyingPrice = prices[i];
            }
        }
        return profit;
    }
}
