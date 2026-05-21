package kyounglin;
import java.util.*;
class Solution {
    public List<int[]>[] graph;
    public List<Integer> infected;
    
    public int max = Integer.MIN_VALUE;

    public int solution(int n, int infection, int[][] edges, int k) {
        graph = new ArrayList[n+1];
        
        for(int i = 0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            int p = edge[2];
            graph[a].add(new int[]{b, p});
            graph[b].add(new int[]{a, p});
        }
        dfs(new ArrayList<>(), k,n, infection);
        
        return max;
    }
    public void dfs(List<Integer> selected, int k, int n, int infection){
        if(selected.size()==k){
            infected = new ArrayList<>();
            infected.add(infection);
            for(int i = 0; i<k; i++){
                infect(selected.get(i), n);
            }     
            max = Math.max(max, infected.size());
            return;
            
        }
        for(int i = 1; i<=3; i++){
            selected.add(i);
                dfs(selected, k, n, infection);
                selected.remove(selected.size()-1);
        }
    }
    public void infect(int pipe, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        for(int i: infected){
            q.add(i);
            visited[i] = true;
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] next: graph[cur]){
                int node = next[0];
                int type = next[1];
                if(!visited[node] && type==pipe){
                    q.add(node);
                    infected.add(node);
                    visited[node] = true;
                }
            }
        }
    }
}
