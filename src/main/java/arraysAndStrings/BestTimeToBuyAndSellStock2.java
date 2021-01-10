package arraysAndStrings;

public class BestTimeToBuyAndSellStock2 {

    //with no limit of transactions

    public static void main(String[] args) {

        int[] in = {8,9,1, 7, 2, 3, 6, 7, 6, 7};
        int ans = maxProfit(in);
        System.out.println(ans);

    }

    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
