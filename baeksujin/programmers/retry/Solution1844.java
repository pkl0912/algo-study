package programmers.retry;
import java.util.*;

public class Solution1844 {


    class Solution {

        int[][] direction = new int[][]{
                {-1,0}, {1,0}, {0,-1}, {0,1}
        };


        public int solution(int[][] maps) {
            int answer = 0;

            // 최단거리

            Deque<int[]> queue = new ArrayDeque<>();

            int n = maps.length;
            int m = maps[0].length;

            queue.offer(new int[]{0,0,1});
            maps[0][0] = 2; //visited

            while(!queue.isEmpty()){

                int[] current = queue.poll();
                int currentX = current[0], currentY = current[1], currentC = current[2];

                if(currentX == n-1 && currentY == m-1){
                    return currentC;
                }

                for(int i=0;i<4; i++){
                    int[] d = direction[i];
                    int nextX = currentX + d[0];
                    int nextY = currentY + d[1];
                    int nextCount = currentC + 1;

                    if(nextX >=0 && nextY >=0  && nextX<n && nextY <m
                            && maps[nextX][nextY] == 1){

                        queue.offer(new int[]{nextX, nextY, nextCount});
                        maps[nextX][nextY] = 2;


                    }
                }


            }


            return -1;
        }
    }
}
