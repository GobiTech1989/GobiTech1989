package top150qa;

public class BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		int[] prices = {1,2,3,4,5};
		int maxProfit = maxProfit(prices);
		System.out.println("Max Profit ::"+maxProfit);
	}
	
	public static int maxProfit(int[] prices) {
        int sum = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
        	if (prices[(i + 1)] > prices[i]) {
        		sum += prices[(i + 1)] - prices[i];
        	}
        }
        return sum;
    }

}
