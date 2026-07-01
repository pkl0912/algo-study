package kyounglin;

import java.util.function.Function;

class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int n = depth.length;
        int[][] dp = new int[n][n];
        int[][] choice = new int[n][n]; 

        for (int i = 0; i < n; i++) {
            dp[i][i] = depth[i];
            choice[i][i] = i;
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int m = l; m <= r; m++) {
                    int cost = depth[m];
                    int worst = 0;
                    if (m > l) worst = Math.max(worst, dp[l][m - 1]);
                    if (m < r) worst = Math.max(worst, dp[m + 1][r]);
                    cost += worst;

                    if (cost < dp[l][r]) {
                        dp[l][r] = cost;
                        choice[l][r] = m;
                    }
                }
            }
        }

        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = choice[lt][rt];
            int result = excavate.apply(mid + 1); 
            if (result == 0) return mid + 1;
            else if (result == 1) lt = mid + 1;
            else rt = mid - 1;
        }
        return 0;
    }
}