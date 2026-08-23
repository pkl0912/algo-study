import java.util.*;
class Solution {

    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];
        dp[0] = 0L;
        dp[1] = 1L;
        
        for(int i = 2; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 1234567;
        }
        return (int)dp[n];
    }
    
}