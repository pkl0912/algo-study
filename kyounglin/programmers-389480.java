package kyounglin;
import java.util.*;
class Solution {
    int min = Integer.MAX_VALUE;
    boolean[][][] visited;
    public int solution(int[][] info, int n, int m) {
        visited = new boolean[info.length+1][n][m];
        dfs(0,0,0,n, m, info);
        return min==Integer.MAX_VALUE ? -1 : min;
        
    }
    public void dfs(int idx, int aSum, int bSum, int n, int m, int[][] info){
        if(aSum>=n || bSum >=m) return;
        if(visited[idx][aSum][bSum]) return;
        
        visited[idx][aSum][bSum] = true;
        
        if(idx==info.length){
            min = Math.min(min, aSum);
            return;
        }
        dfs(idx+1, aSum+info[idx][0], bSum, n, m, info);
        dfs(idx+1, aSum, bSum+info[idx][1], n, m, info);
    }

    
}