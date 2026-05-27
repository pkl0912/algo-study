import java.util.function.Function;

class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int n = depth.length;
        // dp[l][r] = 범위 [l, r]에서 보물을 확실히 찾는 최소 비용
        int[][] dp = new int[n][n];
        int[][] choice = new int[n][n]; // 어떤 열을 파야 하는지

        // 길이 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = depth[i];
            choice[i][i] = i;
        }

        // 길이 2 이상
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int m = l; m <= r; m++) {
                    // m을 파면: 비용 depth[m] + 최악의 경우
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

        // choice 테이블에 따라 excavate 실행
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = choice[lt][rt];
            int result = excavate.apply(mid + 1); 
            else if (result == 1) lt = mid + 1;
            else rt = mid - 1;
        }
        return 0;
    }
}