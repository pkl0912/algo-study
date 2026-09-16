import java.util.*;

class Solution {
    public char[][] graph;
    public int[] dx = new int[]{-1,0,1,0};
    public int[] dy = new int[]{0,-1,0,1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        
        graph = new char[n+2][m+2];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                graph[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for(String request: requests){
            char alpha = request.charAt(0);
            if(request.length()==1){
                bfs(alpha, n, m);
            }else{
                find(alpha, n, m);
            }
        }
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(graph[i][j]!=0) answer++;
            }
        }
        
        
        return answer;
    }
    public void find(char alpha, int n, int m){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(graph[i][j]==alpha) graph[i][j] = 0;
            }
        }
    }
    public void bfs(char alpha, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        boolean[][] visited = new boolean[n+2][m+2];
        visited[0][0] = true;
            
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if(graph[x][y]==alpha){
                graph[x][y] = 0;
            }
            
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
               
                
                if(0<=nx && nx<=n+1 && 0<=ny && ny<=m+1){
                    if(visited[nx][ny]) continue;
                    if(graph[nx][ny]==0){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    } 
                    else if (graph[nx][ny] == alpha) {
                        graph[nx][ny] = 0;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}