package programmers.retry;

public class Solution389480_2 {

    class Solution {
        public int solution(int[][] info, int n, int m) {
            int answer = Integer.MAX_VALUE;


            // a,b 도둑의 흔적의 누적 개수의 최솟값 -> 힌트의 누적개수를 저장.


            //[a흔적개수][b흔적개수]
            boolean[][] cost = new boolean[n][m];
            cost[0][0] = true;

            for(int i =0; i<info.length; i++){

                int[] current = info[i];

                int costA = current[0];
                int costB = current[1];
                boolean[][] next = new boolean[n][m];
                for(int x= 0; x <n; x++){
                    for(int y=0; y<m; y++){

                        if(cost[x][y] == true){

                            int nextA = costA + x;
                            if(nextA < n){
                                next[nextA][y] = true;
                            }

                            int nextB = costB + y;
                            if(nextB < m){
                                next[x][nextB] = true;
                            }

                        }
                    }

                }
                cost = next;

            }


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(cost[i][j] == true){
                        answer = Math.min(answer, i);
                    }
                }

            }


            return answer == Integer.MAX_VALUE ? -1 : answer;
        }
    }
}
