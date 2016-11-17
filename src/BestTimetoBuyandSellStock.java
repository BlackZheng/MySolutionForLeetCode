
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        int max = 0;
        int buyingPrice = 0;
        if(prices.length > 0)
            buyingPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
//        	when price[i] is larger than buying price, remember the profit
        	if(prices[i] > buyingPrice)
                max = Math.max(max, prices[i] - buyingPrice);
//        	when price[i] is less than buying price, it means we can buy one share of stock at lower price
            else
                buyingPrice = prices[i];
        }
        return max;
    }
}
