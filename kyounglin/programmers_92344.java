import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] diff = new int[n+1][m+1];
        
        for(int[] sk: skill){
            int d = sk[5];
            int p = sk[0];
            int x1 = sk[1];
            int y1 = sk[2];
            int x2 = sk[3];
            int y2 = sk[4];
            int val = p==1 ? -d : d;
            
            diff[x1][y1]+=val;
            diff[x1][y2+1]-=val;
            diff[x2+1][y1]-=val;
            diff[x2+1][y2+1]+=val;
                
        }
        for(int i = 0; i<=n; i++){
            for(int j = 1; j<=m; j++){
                diff[i][j] += diff[i][j-1];
            }
        }
        
        for(int j= 0; j<=m; j++){
            for(int i = 1; i<=n; i++){
                diff[i][j]+=diff[i-1][j];
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j]+diff[i][j]>0) answer++;
            }
        }
        return answer;
    }
}