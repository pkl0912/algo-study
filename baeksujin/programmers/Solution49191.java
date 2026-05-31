package programmers;

import java.util.*;

public class Solution49191 {

    class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;

            // 1 2 5 / 4 3 2 5
            // 앞에있는 노드수 + 뒤에 있는 노드수 = N-1 -> 순위확정

            // 1. 그래프 초기화
            List<Integer>[] winGraph = new ArrayList[n+1];
            List<Integer>[] loseGraph = new ArrayList[n+1];

            for(int i=1; i<=n; i++){
                winGraph[i] = new ArrayList<>();
                loseGraph[i] = new ArrayList<>();
            }

            // 2. 그래프 구성
            for(int[] r : results){
                int winner = r[0];
                int loser = r[1];

                winGraph[winner].add(loser);  // winner → loser
                loseGraph[loser].add(winner); // loser ← winner
            }

            for(int i=1; i<=n; i++){
                int winCount = bfs(i, winGraph,n);   // 앞
                int loseCount = bfs(i, loseGraph,n); // 뒤

                if(winCount + loseCount == n - 1){
                    answer++;
                }
            }



            return answer;
        }

        public int bfs(int start, List<Integer>[] graph, int n){

            boolean visited[] = new boolean[n+1];
            Deque<Integer> queue = new ArrayDeque<>();

            queue.offer(start);
            visited[start] = true;
            int cnt = 0;

            while(!queue.isEmpty()){

                int current = queue.poll();

                for(int next : graph[current]){

                    if(visited[next]!=true){
                        visited[next] = true;
                        queue.offer(next);
                        cnt +=1;
                    }

                }

            }

            return cnt;

        }
    }
}
