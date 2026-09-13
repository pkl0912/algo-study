package leetcode;

import java.util.Arrays;

public class Solution300 {

    // todo : 이분탐색으로 풀어보기
    class Solution {
        public int lengthOfLIS(int[] nums) {

            // 최장 증가하는 부분수열
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp,1);

            for(int i=0; i<n; i++){

                for(int j=0; j<i; j++){
                    if(nums[i] > nums[j]){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }

            }

            int max = 1;
            for(int num : dp){
                max = Math.max(max, num);
            }

            return max;
        }
    }
}
