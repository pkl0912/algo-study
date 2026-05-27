package programmers;

import java.util.*;
public class Solution49189 {


    class Solution {
        public int solution(int n, int[][] vertex) {

            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for(int[] v : vertex){
                graph.get(v[0]).add(v[1]);
                graph.get(v[1]).add(v[0]);
            }

            // 간선수
            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);

            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            dist[1] = 0;

            // BFS
            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int next : graph.get(cur)){
                    if(dist[next] == -1){ //방문하지 않은 (최단거리) 중 간선수가 많은 것
                        dist[next] = dist[cur] + 1;
                        queue.offer(next);
                    }
                }
            }

            // 최대 거리 찾기
            int max = 0;
            for(int d : dist){
                max = Math.max(max, d);
            }

            // 최대 거리 개수
            int count = 0;
            for(int d : dist){
                if(d == max) count++;
            }

            return count;
        }
    }
}
