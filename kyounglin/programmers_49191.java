import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] win = new int[n+1][n+1];
        
        if(n==1) return 1;
        
        for(int[] result: results){
            int x = result[0];
            int y = result[1];
            win[x][y] = 1;
        }
        
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    if(win[i][k]==1 && win[k][j]==1){
                        win[i][j] = 1;
                       
                    }
                }
            }
        }
        int[] count = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
               if(win[i][j]==1) count[i]++;
            }
        }
        
        for(int j = 1; j<=n; j++){
            for(int i = 1; i<=n; i++){
                if(win[i][j]==1) count[j]++;
            }
        }
        int answer = 0;
        for(int i = 1; i<=n; i++){
            if(count[i]==n-1) answer++;
        }
        
        return answer;
    }
}