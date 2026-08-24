package programmers;

import java.util.*;
public class Solution87694 {

    class Solution {
        private static final int[] DX = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        private static final int[] DY = {0, 0, -1, 1};
        private static final int SIZE = 102;

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int[][] graph = new int[SIZE][SIZE];
            boolean[][] visited = new boolean[SIZE][SIZE];

            // 겹친 부분(내부)은 -1, 테두리는 1로 표시
            for (int[] r : rectangle) {
                int x1 = r[0] * 2;
                int y1 = r[1] * 2;
                int x2 = r[2] * 2;
                int y2 = r[3] * 2;

                for (int i = x1; i <= x2; i++) {
                    for (int j = y1; j <= y2; j++) {
                        if (x1 < i && i < x2 && y1 < j && j < y2) {
                            graph[i][j] = -1;
                        } else if (graph[i][j] != -1) {
                            graph[i][j] = 1;
                        }
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            int startX = characterX * 2;
            int startY = characterY * 2;
            int targetX = itemX * 2;
            int targetY = itemY * 2;

            queue.offer(new int[]{startX, startY, 0});
            visited[startX][startY] = true;

            return bfs(graph, queue, targetX, targetY, visited);
        }

        private int bfs(int[][] graph, Queue<int[]> queue, int itemX, int itemY, boolean[][] visited) {
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int currentCount = current[2];

                if (currentX == itemX && currentY == itemY) {
                    return currentCount / 2;
                }

                for (int d = 0; d < 4; d++) {
                    int tempX = currentX + DX[d];
                    int tempY = currentY + DY[d];

                    if (tempX >= 1 && tempX <= 102 && tempY >= 1 && tempY <= 102
                            && !visited[tempX][tempY] && graph[tempX][tempY] == 1) {
                        queue.offer(new int[]{tempX, tempY, currentCount + 1});
                        visited[tempX][tempY] = true;
                    }
                }
            }

            return 0;
        }
    }
}
