package kyounglin;

import java.util.*;
class Solution {
    public boolean[] visited;
    public List<Integer>[] arr;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        arr = new ArrayList[n];
        for(int i = 0; i<n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i<n; i++){
            int[] computer = computers[i];
            for(int j = 0; j<n; j++){
                if(i!=j && computer[j]==1){
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next: arr[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}