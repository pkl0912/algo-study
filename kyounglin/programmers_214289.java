import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        if(temperature>t2){
            temperature= t1 - (temperature-t2);
        }
        t1= t1-temperature;
        t2= t2- temperature;
        temperature = 0;
        
        int[][] dp = new int[onboard.length][t2+1];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][temperature] = 0;
        
        for(int i = 0; i<onboard.length-1; i++){
            int low = 0;
            int high = t2;
            if(onboard[i]==1){
                low = t1;
            }
            for(int j = low; j<=high; j++){
                if(dp[i][j]==Integer.MAX_VALUE){
                    continue;
                }
                //유지
                if(j==temperature){
                    dp[i+1][j] = Math.min(dp[i][j], dp[i+1][j]);
                }else{
                    dp[i+1][j] = Math.min(dp[i][j]+b, dp[i+1][j]);
                }
                
                //올림
                if(j<t2){
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]+a);
                }
                
                if(j>temperature){
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        int low = 0; int high = t2;
        if(onboard[onboard.length-1]==1) low = t1;
        
        for(int j = low; j<=high; j++){
            answer = Math.min(answer, dp[dp.length-1][j]);
        }
        return answer;
    }

}