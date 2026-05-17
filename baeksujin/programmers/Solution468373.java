package programmers;

import java.util.*;

public class Solution468373 {

    class Solution {
        int p = 3;
        int m;
        int firstNode;
        int max = 0;

        List<List<int[]>> graph = new ArrayList<>();

        public Set<Integer> spread(Set<Integer> infected, int pipeType){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[graph.size()];

            for(int node : infected){
                q.offer(node);
                visited[node] = true;
            }

            Set<Integer> newInfected = new HashSet<>(infected);

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int[] next : graph.get(cur)){
                    int nextNode = next[0];
                    int nextPipe = next[1];

                    if(nextPipe == pipeType && !visited[nextNode]){
                        visited[nextNode] = true;
                        newInfected.add(nextNode);
                        q.offer(nextNode);
                    }
                }
            }

            return newInfected;
        }

        public void perm(int[] array, int depth){
            if(depth == m){
                Set<Integer> infected = new HashSet<>();
                infected.add(firstNode);

                // 처음에는 bfs로 풀면서 바로 인접한 노드만탐색함 -> 파이프로 이어져있는 노드 전체 탐색해야함.
                for(int i=0; i<m; i++){
                    infected = spread(infected, array[i]);
                }

                max = Math.max(max, infected.size());
                return;
            }

            for(int i=0; i<p; i++){
                array[depth] = i+1;
                perm(array, depth+1);
            }
        }


        // dp가 아닌이유는 앞의 최적이 뒤의 최적이 꼭 아닐 수 있음.
        public int solution(int n, int infection, int[][] edges, int k) {
            graph = new ArrayList<>();

            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }

            for(int[] e : edges){
                graph.get(e[0]).add(new int[]{e[1], e[2]});
                graph.get(e[1]).add(new int[]{e[0], e[2]});
            }

            firstNode = infection;
            m = k;

            int[] array = new int[m];
            perm(array, 0);

            return max;
        }
    }
}
