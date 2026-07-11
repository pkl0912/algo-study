package kyounglin;

import java.util.*;

class Solution {
    class Node{
        int to;
        int val;
        public Node(int to, int val){
            this.to = to;
            this.val = val;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] graph = new ArrayList[n+1];
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
        
        for(int i = 0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            int a = path[0];
            int b = path[1];
            int c = path[2];
            
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );
        
        for(int gate: gates){
            pq.add(new int[]{gate, 0});
            dist[gate] = 0;
        }
        
        List<Integer> summit = new ArrayList<>();       
        for(int s: summits){
            summit.add(s);
        }
        
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int val = cur[1];
           
            if(summit.contains(now)) continue;
            if(val>dist[now]) continue;
            
            
            for(Node next: graph[now]){
                int max = Math.max(val, next.val);
                
                if(dist[next.to]>max){
                    dist[next.to] = max;
                    pq.add(new int[]{next.to, max});
                }
            }
        }
        Arrays.sort(summits);
        for(int s: summits){
            if(dist[s]<minIntensity){
                minIntensity = dist[s];
                minSummit = s;
            }
        }
        
        return new int[]{minSummit, minIntensity};
    }
    
}