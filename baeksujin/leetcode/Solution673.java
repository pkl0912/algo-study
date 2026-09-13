package leetcode;

import java.util.Arrays;

public class Solution673 {

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            // 가장 긴 증가하는 부분수열을 만드는 경우의 수. dp갱신 시점일때의 cnt저장필요

            int n = nums.length;
            int[] dp = new int[n];
            int[] cnt = new int[n];
            Arrays.fill(dp, 1);
            Arrays.fill(cnt, 1);


            for(int i=0; i<n; i++){
                for(int j=0; j<i; j++){

                    if(nums[i] > nums[j]){ // 증가하는 수열에 해당됨
                        if(dp[i] == dp[j]+1){
                            cnt[i] += cnt[j];
                        }else if(dp[i] < dp[j] + 1){// 지금까지의 최댓값에 해당
                            cnt[i] = cnt[j];
                            dp[i] = dp[j]+1;
                        }
                    }

                }
            }

            // 가장 긴 수열의 길이
            int maxLen = 0;
            for(int num : dp){
                maxLen = Math.max(num, maxLen);
            }

            // 가장 긴 수열의 길이의 경우의 수중, cnt 최댓값
            int maxCnt = 0;
            for(int i=0; i<n; i++){
                if(dp[i] == maxLen){
                    maxCnt+=cnt[i];
                }
            }

            return maxCnt;

        }
    }
}
