package programmers;

// 예전 풀었던 문제와 동일한것같음..?
public class Solution619967_268 {

    class Solution {
        public int solution(int sticker[]) {
            int answer = 0;

            int n = sticker.length;

            if(n==1){
                return sticker[0];
            }
            // 맨 처음꺼를 사용하는 경우 -> 마지막 x
            int[] dp1 = new int[n];
            dp1[0] = sticker[0];
            dp1[1] = Math.max(dp1[0], sticker[1]);
            // 처음+1벝부터 사용하는 경우 -> 마지막 o
            int[] dp2 = new int[n];
            dp2[0] = 0;
            dp2[1] = sticker[1];

            for(int i=2; i<n-1; i++){
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
            }

            for(int i=2; i<n; i++){
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            }



            return Math.max(dp1[n-2], dp2[n-1]);
        }
    }
}
