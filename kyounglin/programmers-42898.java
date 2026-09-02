import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] puddle = new boolean[n][m];
        for(int[] pud: puddles){
            int x = pud[0]-1;
            int y = pud[1]-1;
            puddle[y][x] = true;
        }
        dp[0][0] = 1;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(puddle[i][j]) continue;
                
                if (i == 0 && j == 0) {
                    continue;
                }

                int top = i > 0 ? dp[i - 1][j] : 0;
                int left = j > 0 ? dp[i][j - 1] : 0;

                dp[i][j] = (top + left) % MOD;
            }
        }

        int answer = dp[n-1][m-1];
        return answer;
    }
}