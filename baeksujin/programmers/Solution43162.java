package programmers;
import java.util.*;
public class Solution43162 {

    class Solution {

        boolean[] visited;
        int N;
        public int solution(int n, int[][] computers) {
            int answer = 0;

            visited = new boolean[n];
            N = n;

            // bfs를 통해서 연결된 트리를 탐색

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(computers[i][j]==1 && visited[i]==false){
                        visited[i] = true;
                        Deque<Integer> queue = new ArrayDeque<>();
                        queue.offer(i);
                        bfs(queue, computers);
                        answer+=1;
                    }
                }
            }

            return answer;
        }

        public void bfs(Deque<Integer> queue, int[][] computers){


            while(!queue.isEmpty()){

                Integer current = queue.poll();

                for(int n=0; n<N; n++){
                    if(computers[current][n] == 1 && visited[n]==false){
                        visited[n] = true;
                        queue.offer(n);
                    }
                }



            }


        }
    }
}
