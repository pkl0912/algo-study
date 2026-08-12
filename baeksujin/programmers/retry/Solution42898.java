package programmers.retry;

import java.util.*;

public class Solution42898 {



    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;

            // 최단경로의 개수
            // 왼쪽과 위

            int[][] map = new int[n][m];
            map[0][0] = 1;

            boolean[][] zero = new boolean[n][m];

            for(int i=0; i<puddles.length; i++){
                zero[puddles[i][1]-1][puddles[i][0]-1] = true;
            }


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){

                    if(i==0 && j==0) continue;


                    if(zero[i][j] ==true){
                        // 웅덩이인경우 경우의 수 0
                        map[i][j] = 0;
                        continue;

                    }

                    if(i-1 >= 0){
                        map[i][j] += map[i-1][j] % 1000000007;
                    }
                    if(j-1>=0){
                        map[i][j] += map[i][j-1] % 1000000007;
                    }


                }
            }


//         for(int i=0; i<n; i++){
//             System.out.println(Arrays.toString(map[i]));
//         }


            return map[n-1][m-1] % 1000000007;
        }
    }

}
