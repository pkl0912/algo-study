package kyounglin;

import java.util.*;
class Solution {
    public int[] dx = {-1,0,1,0};
    public int[] dy = {0,-1,0,1};
    
    public int solution(String[] board) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int x = 0;
        int y = 0;
        int gx = 0;
        int gy = 0;
        
        int n = board.length;
        int m = board[0].length();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i].charAt(j)=='R'){
                    x = i;
                    y = j;
                }else if(board[i].charAt(j)=='G'){
                    gx = i;
                    gy = j;
                }
            }
        }
        q.add(new int[]{x, y, 0});
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int sx = cur[0];
            int sy = cur[1];
            int dist = cur[2];
            if(sx==gx && sy==gy){
                answer = dist;
                return answer;
            }
            for(int i = 0; i<4; i++){
                int[] newArr = move(board, sx, sy, i);
                if(!visited[newArr[0]][newArr[1]]){
                    visited[newArr[0]][newArr[1]] = true;
                    q.add(new int[]{newArr[0], newArr[1], dist+1});
                }
            }
        }
        return -1;
    }
    public int[] move(String[] board, int x, int y, int d){
        int n = board.length;
        int m = board[0].length();
        int nx = x;
        int ny = y;
        while(0<=nx+dx[d] && nx+dx[d]<n && 0<=ny+dy[d] && ny+dy[d]<m && board[nx+dx[d]].charAt(ny+dy[d])!='D'){
            nx+=dx[d];
            ny+=dy[d];
        }
        return new int[]{nx, ny};
    }
}