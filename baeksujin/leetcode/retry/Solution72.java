package leetcode.retry;

public class Solution72 {

    class Solution {
        public int minDistance(String word1, String word2) {

            char[] c1 = word1.toCharArray();
            char[] c2 = word2.toCharArray();
            int n = c1.length+1, m = c2.length+1;

            int[][] dp = new int[n][m];


            for(int i=0; i<n; i++){
                dp[i][0] = i;//remove
            }
            for(int j=0; j<m; j++){
                dp[0][j] = j; // insert
            }

            for(int i=1; i<n; i++){
                for(int j=1; j<m; j++){
                    if(c1[i-1] == c2[j-1]){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1]) + 1;
                    }
                }
            }

            return dp[n-1][m-1];
        }
    }
}
