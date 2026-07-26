package programmers.retry;

public class Solution389480 {
    class Solution {
        public int solution(int[][] info, int n, int m) {
            int answer = Integer.MAX_VALUE;


            boolean[][] map = new boolean[n][m];
            map[0][0] = true; // 아무것도 안한상태

            for( int k=0; k<info.length; k++){

                int aCost = info[k][0];
                int bCost = info[k][1];
                boolean[][] next = new boolean[n][m];

                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){

                        // 이전 기록 기반 탐색
                        if(map[i][j] == true){

                            // A로 가능한지 체크
                            int nextA = i + aCost;
                            if(nextA < n){
                                next[nextA][j] = true;
                            }

                            // B로 가능한지 체크
                            int nextB = j + bCost;
                            if(nextB < m){
                                next[i][nextB] = true;
                            }

                        }

                    }
                }

                map = next;
            } // 현재 선택의 최선이 항상 뒹의 최선이 아님. dp


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] == true){
                        answer = Math.min(answer, i);
                    }
                }
            }



            return answer == Integer.MAX_VALUE ? -1 : answer;
        }
    }
}
