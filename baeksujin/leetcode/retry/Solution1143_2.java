package leetcode.retry;

public class Solution1143_2 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {

            // 문제 : 겹치는 알파벳의 개수. ( 사용 : 겹칠때 +1 , 미사용 : 이전값 그대로 유지 )
            // (a,c,e)(a,b,c,d,e) -> a : 1,1,1,1,1 / c : 1, 1,2,2,2 / e : 1,1,2,2,(2+1)

            // init

            char[] t1 = text1.toCharArray();
            char[] t2 = text2.toCharArray();

            int n = text1.length();
            int m = text2.length();
            // // 누적값을 저장 ( 선택 -> dp[i-1][j-1] 대각선 = 둘다 사용 )  / 미선택( 불일치 ) -> 둘중 하나를 버림.
            // int[][] dp = new int[n+1][m+1]; // 공간복잡도 : O(NM) = O(N^2)
            // for(int i=0; i<=n; i++){
            //     dp[i][0] = 0;
            // }
            // for(int j=0; j<=m; j++){
            //     dp[0][j] = 0;
            // }
            int[] dp = new int[m+1]; // 공간복잡도 : O(M) // 초기화 -> 전체 0

            // dp 갱신
            // for(int i=1; i<=n; i++){ // n
            //     for(int j=1; j<=m; j++){ //m

            //         //  현재값이 동일하여 +1 -> 사용하는 경우
            //         if( t1[i-1] == t2[j-1]){
            //             dp[i][j] = dp[i-1][j-1] + 1;
            //         }

            //         // 현재값이 동일하지 않은 경우 --> 비교
            //         else{
            //             dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            //         }

            //     }
            // } // 시간복잡도 O(NM) = O(N^2)
            for(int i=1; i<=n; i++){
                int diag = 0;
                // dp[i] = 이차원배열로 dp[i-1][j];
                for(int j=1; j<=m; j++){
                    int temp = dp[j]; // 대각선 임시저장
                    // 동일 -> 둘다 사용
                    if(t1[i-1] == t2[j-1]){
                        dp[j] = diag + 1;
                    }
                    else{ // 다른 경우  -> 하나만 사용
                        dp[j] = Math.max(dp[j], dp[j-1]); // 위 : dp[j] 옆 dp[j-1]
                    }
                    diag = temp; // 현재 대각선 -> 다음 턴에 사용가능하도록 저장
                }
            } // 공간복잡도 : O(N)


            // result
            return dp[m];


        }
    }
}
