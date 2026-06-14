package programmers;

public class Solution42898 {

    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;

            int[][] count = new int[n+1][m+1];
            boolean[][] zero = new boolean[n+1][m+1];

            for(int i=0; i<puddles.length; i++){
                zero[puddles[i][1]][puddles[i][0]] = true;
            }


            count[1][1] = 1;

            for(int i=1; i<n+1; i++){

                for(int j=1; j<m+1; j++){

                    if(zero[i][j] ==true){
                        // 웅덩이인경우 경우의 수 0
                        count[i][j] = 0;
                        continue;

                    }

                    if(i==1 && j==1){
                        continue;
                    }

                    count[i][j] = (count[i-1][j] + count[i][j-1]) % 1000000007;

                }



            }



            return count[n][m];
        }
    }
}
