package programmers;
import java.util.*;
public class Solution389480 {



    class Solution {
        public int solution(int[][] info, int n, int m) {
            int answer = 999999;

            // n,m 기준으로 이차원 dp 진행. 가능한 영역에 대해 체크하고 흔적을 남길 수 있는지 확인

            boolean map[][] = new boolean[n][m]; // 매번 초기화 필요한 이유는, 훔칠때마다 이전결과만 반영해야하ㅡㄴㄴ데 누적이면 이전의이전까지 반영함..
            map[0][0] = true;

            // n-> a, m ->b
            for(int[] c : info){

                boolean[][] next = new boolean[n][m];

                int currentX = c[0];
                int currentY = c[1];

                // 탐색 시도 가능한 이전 list
                for(int i=0; i<n; i++){ // before탐색
                    for(int j=0; j<m; j++){
                        if(map[i][j] == true){

                            // x방향 혹은 y방향 가능한 방향으로 이동
                            int nextX = currentX + i;
                            if(nextX < n){
                                next[nextX][j] = true;
                            }


                            int nextY = currentY + j;
                            if(nextY <m){
                                next[i][nextY] = true;
                            }

                        }
                    }

                }

                map = next;
            }


            // a를 최소한 사용하는 경우
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]){
                        answer = Math.min(answer, i);
                    }
                }
            }

            return answer == 999999 ? -1 : answer;
        }
    }
}
