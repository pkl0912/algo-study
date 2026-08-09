package kyounglin;

import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        
        long[] a = new long[n];
        long[] b = new long[n];
        long[] dp = new long[n];
        dp[0] = Math.max(a[0], b[0]);
        
        for(int i = 0; i<n; i++){
            a[i] = (i%2==0) ? sequence[i] : sequence[i]*(-1);
            b[i] = (i%2!=0) ? sequence[i] : sequence[i]*(-1);
        }
        for(int i = 1; i<n; i++){
            a[i] = Math.max(a[i], a[i-1]+a[i]);
            b[i] = Math.max(b[i], b[i-1]+b[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        answer = Math.max(a[n-1], b[n-1]);
        
        return answer;
    }
}