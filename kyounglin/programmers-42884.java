package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        
        for(int i = 0; i<n; i++){
            int[] route = routes[i];
            q.add(new int[]{route[0], route[1], i});
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int idx = cur[2];
            
            if(visited[idx]) continue;
            
            for(int i = 0; i<n; i++){
                int[] route = routes[i];
                if(!visited[i] && route[0]<=y && y<=route[1]){
                    visited[i] = true;
                }
            }   
            answer++;
        }
        return answer;
    }
}