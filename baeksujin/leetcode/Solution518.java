package leetcode;

public class Solution518 {

    class Solution {
        public int change(int amount, int[] coins) {

            int n = coins.length+1;
            int m = amount+1;
            int[][] dp = new int[n][m];

            // init
            for(int i=0; i<n; i++){
                dp[i][0] = 1;
            }

            for(int i=1; i<n; i++){
                for(int j=1; j<m; j++){

                    if(  j >= coins[i-1] ){// amount >= coin ~
                        dp[i][j] = dp[i-1][j]  // 이전조합으로 나온 경우
                                + dp[i][j - coins[i-1]]; // 현재 coins을 활용할 경우도 고려
                    } else{
                        dp[i][j] = dp[i-1][j]; /// 현재 coin보다 amount가 적을때 coin 활용 못함
                    }


                }
            }


            return dp[n-1][m-1];
        }
    }
}
