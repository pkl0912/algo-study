package leetcode;

import java.util.Arrays;

public class Solution198 {

    class Solution {
        public int rob(int[] nums) {

            // 강도는 인접한 곳을 털지못하는 제약이 존재. 붙어있으면 강제 종료
            // 걸리지 않는 선에서 최대로 훔칠수있는 돈을 구하기
            int n = nums.length;
            if(n==1){
                return nums[0];
            }
            if(n==2){
                return Math.max(nums[1], nums[0]);
            }

            // 첫번째 집 털기
            int[] dp1 = new int[n];
            dp1[0] = nums[0];
            dp1[1] = Math.max(nums[0],nums[1]);

            // scan dp[i] = max(dp[i-2] + dp[i], dp[i-1]);
            for(int i=2; i<n; i++){
                dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
            }

            System.out.println(Arrays.toString(dp1));

            return dp1[n-1];
        }
    }
}
