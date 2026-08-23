package programmers;
import java.util.*;
public class Solution84021 {



    class Solution {

        final int[][] directions = new int[][]{
                {-1,0}, {1,0}, {0,-1}, {0,1}
        };


        public ArrayList<ArrayList<int[]>> bfs(int[][] map, int target){

            int n = map.length;
            boolean visited[][] = new boolean[n][n];
            ArrayList<ArrayList<int[]>> list = new ArrayList<>();

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){


                    if(map[i][j] == target && visited[i][j] == false){

                        Queue<int[]> queue = new ArrayDeque<>();
                        ArrayList<int[]> piece = new ArrayList<>();
                        piece.add(new int[]{i, j});
                        queue.offer(new int[]{i, j});

                        visited[i][j] = true;

                        while(!queue.isEmpty()){

                            int[] current = queue.poll();

                            for(int[] d : directions){
                                int nextX = current[0] + d[0];
                                int nextY = current[1] + d[1];

                                if(nextX >=0 && nextX <n && nextY >=0 && nextY <n
                                        && visited[nextX][nextY] == false && map[nextX][nextY] == target){

                                    visited[nextX][nextY] = true;
                                    queue.offer(new int[]{nextX, nextY});
                                    piece.add(new int[]{nextX, nextY});

                                }
                            }

                        }

                        list.add(piece);
                    }


                }

            }


            return list;

        }// 5m

        public int[][] compact(ArrayList<int[]> piece){

            int minX = 51, minY = 51;
            int maxX = 0, maxY = 0;
            for(int[] p : piece){
                int pX = p[0], pY = p[1];

                minX = Math.min(pX, minX);
                minY = Math.min(pY, minY);
                maxX = Math.max(pX, maxX);
                maxY = Math.max(pY, maxY);
            }

            int[][] result = new int[maxX-minX+1][maxY-minY+1];

            // 왼쪽 좌측으로 압축
            for(int[] p : piece){
                int pX = p[0], pY = p[1];

                int cX = pX - minX;
                int cY = pY - minY;

                result[cX][cY] = 1;
            }

            return result;
        }// 5m

        // 90' 회전
        public int[][] rotate90(int[][] current){

            int xSize = current.length;
            int ySize = current[0].length;

            int[][] result = new int[ySize][xSize];

            // rotate
            for (int i = 0; i < xSize; i++) {
                for (int j = 0; j < ySize; j++) {

                    result[j][xSize - 1 - i] = current[i][j];

                }
            }


            return result;
        }

        public int solution(int[][] game_board, int[][] table) {
            int answer = -1;

            // 빈칸 퍼즐구하기
            // 색칠 퍼즐구하기
            int count = 0;

            ArrayList<ArrayList<int[]>> boards = bfs(game_board, 0);
            ArrayList<ArrayList<int[]>> tables = bfs(table, 1);


            // board에 맞는 table찾기 / table 재사용X
            // board compace == table compact를 비교 (rotate가능.table rotage)
            boolean[] usedTable = new boolean[tables.size()];
            for(ArrayList<int[]> board : boards){

                // board에 맞는 table을 찾는순간 다음 board탐색
                boolean boardUsed = false;
                int[][] normalizedB = compact(board);

                for(int i=0; i< tables.size(); i++){

                    if(usedTable[i]) continue;

                    // currentTable : 정규화후
                    ArrayList<int[]> currentTable = tables.get(i);
                    int[][] normalizedT = compact(currentTable);

                    for (int r = 0; r < 4; r++) {

                        if (Arrays.deepEquals(normalizedT, normalizedB)) {

                            count += board.size();
                            boardUsed = true;
                            usedTable[i] = true;

                            break;
                        }

                        normalizedT = rotate90(normalizedT);
                    }

                    if(boardUsed) break;



                }

            }


            return count;
        }
    }
}
