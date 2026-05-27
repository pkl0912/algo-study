package kyounglin;

import java.util.*;

class Solution {
    public Map<Integer, Integer> map = new HashMap<>();
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    int l = -1;
    
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1){
                    bfs(land, i, j, n, m);
                    l--;
                }
            }
        }
        
        for(int i = 0; i<m; i++){
            Set<Integer> visited = new HashSet<>();
            int sum = 0;
            for(int j = 0; j<n; j++){
                if(land[j][i]!=0){
                    visited.add(land[j][i]);
                }
            }
            for(int v: visited){
                sum+= map.get(v);
            }
            answer = Math.max(sum, answer);
        }
        return answer;
    }
    public void bfs(int[][] land, int sx, int sy, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        land[sx][sy] = l;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            cnt++;
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m && land[nx][ny]==1){
                    q.add(new int[]{nx, ny});
                    land[nx][ny] = l;
                }
            }
        }
        map.put(l, cnt);
    }
}