package leetcode;

public class Solution718 {

    class Solution {
        public int findLength(int[] nums1, int[] nums2) {

            int n = nums1.length+1, m = nums2.length+1;
            int[][] dp = new int[n][m];

            int max = 0;

            for(int i=1; i<n; i++){
                for(int j=1; j<m; j++){

                    if(nums1[i-1] == nums2[j-1]){ // 동일할때 현재 채택.
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        // 다를때 연속이 끊김
                        dp[i][j] = 0;
                    }

                    max = Math.max(max, dp[i][j]);

                }
            }

            return max;

        }
    }
}
