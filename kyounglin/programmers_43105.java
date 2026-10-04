import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=i; j++){
                int next = 0;
                if(j==0) next = dp[i-1][j];
                else if(j==i) next = dp[i-1][j-1];
                else next = Math.max(dp[i-1][j],dp[i-1][j-1]);
                dp[i][j] = triangle[i][j]+next;
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(max, dp[n-1][i]);
        }
        answer = max;
        return answer;
    }
}