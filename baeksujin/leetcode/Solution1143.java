package leetcode;

public class Solution1143 {

    class Solution {

        public int longestCommonSubsequence(String text1, String text2) {
            // 가장 긴 겹치는 문자열
            int count = 0;
            char[] c1 = text1.toCharArray();
            char[] c2 = text2.toCharArray();


            // 동일 dp[i][j] = 1 + dp[i-1][j-1]
            // 다름 Math.max(dp[i-1][j], dp[i][j-1])

            int[][] dp = new int[c1.length+1][c2.length+1];

            for(int i=1; i<c1.length+1; i++){
                for(int j=1; j<c2.length+1; j++){

                    if(c1[i-1] == c2[j-1]){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }




            return dp[c1.length][c2.length];

        }
    }
}
