package kyounglin;

import java.util.*;

class Solution {

    int[] dx = {1,0,0,-1}; //d,l,r,u
    int[] dy = {0,-1,1,0};
    String[] dir = {"d", "l", "r", "u"};
    int[][] graph;
    int n, m, x, y, r, c, k;
    String answer = "";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        graph = new int[n][m];
        this.n = n;
        this.m = m;
        this.x = x-1;
        this.y = y-1;
        this.r = r-1;
        this.c = c-1;
        this.k = k;
        int dist = Math.abs(x-r) + Math.abs(y-c);

        if (dist > k || (k-dist)%2 != 0) return "impossible";
        dfs(0, x-1, y-1, "");
        return answer;
    }
    public boolean dfs(int cnt, int cx, int cy, String path){
        if(cnt==k){
            if(cx==r && cy==c){
                answer = path;
                return true;
            }
            return false;
        }
        
        for(int i = 0; i<4; i++){
            int nx = cx+dx[i];
            int ny = cy+dy[i];
            if(0>nx || nx>=n || 0>ny || ny>=m) continue;
            if(Math.abs(nx-r)+Math.abs(ny-c)>k-cnt-1) continue;
            if(dfs(cnt+1, nx, ny, path+dir[i])){
                return true;
            };
        }
        return false;
    }
    
}