package leetcode;

public class Solution72 {

    class Solution {
        public int minDistance(String word1, String word2) {

            // word1 -> word2
            // 모든 경우의 수를 따지기엔 무리

            // dp[i][j] word1(i), word2(j)로 전환을 위해 사용한 최소 연산횟수
            // 초기값 : dp[i][0] : i (remove) dp[0][j] : j (insert). (다시풀어봐야함)

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
                    // 같을때 연산없이 기존 최소 연산횟수를 이어감
                    if(c1[i-1] == c2[j-1]){
                        dp[i][j] = dp[i-1][j-1];
                    }else{ // 다를때 연산을 진행해야함
                        // 3경우중 비교하여 Math.min // i위치에 해당하는 char를 삽입, 삭제, 교환
                        dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1]) + 1;
                    }
                }
            }

            return dp[n-1][m-1];


        }
    }
}
