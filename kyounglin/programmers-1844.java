package kyounglin;

import java.util.*;

class Solution {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        answer = bfs(maps, n, m);
        return answer;
    }
    public int bfs(int[][] maps, int n, int m){
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            if(x==n-1 && y==m-1) return d;
            
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx <n && 0<=ny && ny<m && maps[nx][ny]!=0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, d+1});
                }
            }
        }
        return -1;
    }
}