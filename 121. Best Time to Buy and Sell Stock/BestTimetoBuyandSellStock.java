public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        if(prices.length == 1)
            return 0;
        if(prices.length == 2)
            return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;

        for (int i = prices.length - 1; i > 0; i--) {
            if(maxValue > prices[i] - 1){
                continue;
            }
            int j = i - 1;
            while(j >= 0 && prices[j] < prices[i]){
                int value = prices[i] - prices[j];
                if(value > maxValue)
                    maxValue = value;
                j--;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(prices));
    }
}
