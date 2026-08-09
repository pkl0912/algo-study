package programmers.retry;
import java.util.*;
public class Solution43162 {
    class Solution {


        public int solution(int n, int[][] computers) {
            int answer = 0;

            boolean[] visited = new boolean[n];



            int cost = 0;

            for(int i=0; i<n; i++){

                if(visited[i] == true ){
                    continue;
                }

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                visited[i] = true;

                while(!queue.isEmpty()){

                    int currentNode = queue.poll();

                    for(int j=0; j<n; j++){

                        if(computers[currentNode][j] == 1 && visited[j]!=true){
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }

                }
                answer+=1;

            }



            return answer;
        }
    }
}
