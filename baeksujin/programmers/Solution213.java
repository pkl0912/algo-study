package programmers;

public class Solution213 {

    class Solution {
        public int rob(int[] nums) {

            // circle이 존재할때 인접한 곳은 털 수 없음
            int n = nums.length;
            if(n==1){
                return nums[0];
            }

            // 첫번째를 털때

            int[] dp1 = new int[n];
            dp1[0] = nums[0];
            dp1[1] = Math.max(dp1[0], nums[1]);
            for(int i=2; i<n-1; i++){
                dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
            }

            // 마지막을 털때
            int[] dp2 = new int[n];
            dp2[0] = 0;
            dp2[1] = nums[1];
            for(int i=2; i<n; i++){
                dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
            }

            return Math.max(dp1[n-2], dp2[n-1]);

        }
    }
}
