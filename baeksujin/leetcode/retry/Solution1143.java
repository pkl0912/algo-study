package leetcode.retry;

public class Solution1143 {

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {

            // t1[i][j] == t2[i][j] -> dp[i-1][j-1] + 1
            // else -> Math.max(dp[i-1][j], dp[i][j-1])

            char[] t1 = text1.toCharArray();
            char[] t2 = text2.toCharArray();

            int[][] dp = new int[t1.length+1][t2.length+1];

            for(int i=0; i<t1.length+1; i++){
                dp[i][0] = 0;
            }
            for(int j=0; j<t2.length+1; j++){
                dp[0][j] = 0;
            }

            for(int i=1; i<t1.length+1; i++){
                for(int j=1; j<t2.length+1; j++){

                    if(t1[i-1] == t2[j-1]){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }

                }
            }

            return dp[t1.length][t2.length];

        }
    }
}
