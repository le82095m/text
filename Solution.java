public class Solution {
    /**
     * 计算你能获得的最大收益
     * 1 5 4 3 2 7 2 9
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
        int start1 = 0;
        int end1 = 0;
        int money1 = 0;
        int start2 = 0;
        int end2 = 0;
        int money2 = 0;
        for (int i = 0; i < prices.length-2; i++) {

            for (int j = i+2; j < prices.length-1; j++) {
                if ((prices[j+1] - prices[j]) > money1+money2) {
                    money1 = (prices[i + 1] - prices[j]);
                    start1 = i;
                    end1 = j;
                }
            }
        }
    }
}
