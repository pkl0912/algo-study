package kyounglin;

package kyounglin;
import java.util.*;

class Solution {
    public int[] dx = {1, 0, 0, -1}; //d,l,r,u
    public int[] dy = {0, -1, 1, 0};
    public char[] dir = {'d', 'l', 'r', 'u'};
    public int[][] graph;
    public String answer = "";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        graph = new int[n][m];
        int dist = Math.abs(x-r)+Math.abs(y-c);
        if(dist>k || (k-dist) % 2!= 0) return "impossible";
        boolean possible = dfs(0, "", n, m, x-1, y-1, r-1, c-1, k);
        return answer;
    }
    public boolean dfs(int cnt, String path, int n, int m, int x, int y, int r, int c, int k){
        if(cnt==k && x==r && y==c){
            answer = path;
            return true;
        }
        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            int remain = k - cnt;
            int dist = Math.abs(nx-r) + Math.abs(ny-c);

            if(dist > remain) continue;
            if(0<=nx && nx<n && 0<=ny && ny<m){
                if(dfs(cnt+1, path+dir[i], n, m, nx, ny, r, c, k)){
                    return true;
                };
            }
        }
        return false;
    }
}