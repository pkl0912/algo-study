package programmers;

import java.util.*;

public class Solution1844 {
    class Solution {

        private int[] dirX = new int[]{-1,0,1,0};
        private int[] dirY = new int[]{0,-1,0,1};

        public int solution(int[][] maps) {
            int answer = -1;
            int n = maps.length;
            int m = maps[0].length;
            // bfs활용탐색

            Deque<int[]> dq = new ArrayDeque<>();

            // init
            dq.offer(new int[]{0,0,1});
            boolean[][] visited = new boolean[n][m];
            visited[0][0]=true;

            while(!dq.isEmpty()){
                int[] current = dq.poll();

                int currentX = current[0];
                int currentY = current[1];
                int currentCount = current[2];

                if(currentX == (n-1) && currentY == (m-1)){
                    return currentCount;
                }

                for(int i=0; i<4; i++){

                    int nextX = currentX + dirX[i];
                    int nextY = currentY + dirY[i];
                    int nextCount = currentCount +1;

                    if(nextX >=0 && nextX <n && nextY >=0 && nextY < m && maps[nextX][nextY]!=0 && visited[nextX][nextY] == false){
                        // offer
                        dq.offer(new int[]{nextX, nextY, nextCount});

                        // visited
                        visited[nextX][nextY] = true;
                    }

                }
            }



            return answer;
        }
    }
}
