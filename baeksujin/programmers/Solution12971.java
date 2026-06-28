package programmers;

public class Solution12971 {
    class Solution {
        public int solution(int sticker[]) {
            int answer = 0;

            int n = sticker.length;

            if(n == 1){
                return sticker[0];
            }
            if(n == 2){
                return Math.max(sticker[0], sticker[1]);
            }

            // 첫번째를 선택하는 경우 -> 마지막은 선택하지못함
            int[] dp1 = new int[n];
            dp1[0] = sticker[0];
            dp1[1] = Math.max(sticker[1], dp1[0]) ;
            // 두번째를 선택하는 경우 -> 마지막 선택 가능
            int[] dp2 = new int[n];
            dp2[0] = 0;
            dp2[1] = sticker[1];

            for(int i=2; i<n; i++){
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            }

            // System.out.println(dp1[n-1] + " / " + dp2[n-1]); 실패 tc 15,20 ( dp1[1] setting 코드 잘못짬)


            return Math.max(dp1[n-2], dp2[n-1]);
        }
    }
}
