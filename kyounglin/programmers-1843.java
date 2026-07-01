package kyounglin;

import java.util.*;

class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2; 
        int[] nums = new int[n];
        char[] ops = new char[n - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) nums[i / 2] = Integer.parseInt(arr[i]);
            else ops[i / 2] = arr[i].charAt(0);
        }

        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i]; 
            dp[i][i][1] = nums[i]; 
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int leftMax = dp[i][k][0];
                    int leftMin = dp[i][k][1];
                    int rightMax = dp[k+1][j][0];
                    int rightMin = dp[k+1][j][1];

                    int curMax, curMin;

                    if (ops[k] == '+') {
                        curMax = leftMax + rightMax;
                        curMin = leftMin + rightMin;
                    } else { // '-'
                        curMax = leftMax - rightMin; 
                        curMin = leftMin - rightMax; 
                    }

                    dp[i][j][0] = Math.max(dp[i][j][0], curMax);
                    dp[i][j][1] = Math.min(dp[i][j][1], curMin);
                }
            }
        }

        return dp[0][n-1][0];
    }
}