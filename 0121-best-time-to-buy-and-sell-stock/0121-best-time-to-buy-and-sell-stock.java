class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int mini=prices[0];
        int profit=0;
        for(int i=0;i<n;i++){
           int profit2= prices[i] - mini;
            if(profit <profit2  ) profit=profit2;
            mini=Math.min(mini, prices[i]);
        }
        return profit;
        
    }
}