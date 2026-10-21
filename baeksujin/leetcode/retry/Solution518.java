package leetcode.retry;

public class Solution518 {

    class Solution {
        public int change(int amount, int[] coins) {
            // amount / coins

            // amount 경우의 수
            int[] dp = new int[amount+1];
            dp[0] = 1;


            for(int i=0; i<coins.length; i++){
                int coin = coins[i];
                for(int j=coin; j<amount+1; j++){
                    dp[j] += dp[j-coin];
                }
            }

            return dp[amount];

        }
    }
}
