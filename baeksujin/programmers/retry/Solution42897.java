package programmers.retry;

public class Solution42897 {

    class Solution {
        public int solution(int[] money) {
            int answer = 0;

            int n = money.length;

            // 가장 첫번째집을 터는 경우
            int[] dp1 = new int[n];
            dp1[0] = money[0];
            dp1[1] = Math.max(money[1], money[0]);
            for(int i=2; i<n-1; i++){
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
            }

            // 두번째 집을 털고 첫번째 집을 털지않는 경우
            int[] dp2 = new int[n];
            dp2[0] = 0;
            dp2[1] = money[1];
            for(int i=2; i<n; i++){
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
            }


            return Math.max(dp1[n-2], dp2[n-1]);
        }
    }
}
