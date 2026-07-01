package kyounglin;

import java.util.*;
class Node{
    int to;
    int cost;
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
class Solution {
    public List<Node>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] fare: fares){
            graph[fare[0]].add(new Node(fare[1], fare[2]));
            graph[fare[1]].add(new Node(fare[0], fare[2]));
        }
        int[] distS = dijakstra(s, n, fares);
        int[] distA = dijakstra(a, n, fares);
        int[] distB = dijakstra(b, n, fares);
        for(int k=1; k<=n; k++){
            answer = Math.min(answer, distS[k]+distA[k]+distB[k]);
        }
        return answer;
    }
    public int[] dijakstra(int start, int n, int[][] fares){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int curCost = cur[1];
            for(Node next: graph[now]){
                if(dist[next.to]>dist[now]+next.cost){
                    dist[next.to] = dist[now]+next.cost;
                    pq.add(new int[]{next.to, dist[next.to]});
                }
            }
        }
        return dist;
    }
}