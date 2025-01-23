public class BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int j = i + 1;

            while (j < prices.length && prices[j] > prices[j-1]) {
                j++;
            }
            j--;

            maxValue = maxValue + prices[j] - prices[i];
            i = j;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock2 b = new BestTimetoBuyandSellStock2();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(prices));
    }
}
