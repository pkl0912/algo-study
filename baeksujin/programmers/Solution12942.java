package programmers;
import java.util.*;

public class Solution12942 {


    class Solution {
        public int solution(int[][] matrix_sizes) {
            int answer = 0;

            // 무엇을 먼저 계산하는지에 따라서 결과가 달라짐.(먼저 계산하는 구간을 지정)
            int n = matrix_sizes.length;

            int[][] dpMin = new int[n][n];// i~j를 먼저 계산
            for(int i=0; i<n; i++){
                Arrays.fill(dpMin[i], Integer.MAX_VALUE);
                dpMin[i][i] = 0;
            }

            // 먼저 연산할 것들을 묶음. 이차원배열처리
            for(int len =2; len <= n; len ++){

                for( int i=0; i<=n-len; i++){
                    int j = i+len-1;

                    for(int k=i; k<j; k++){
                        dpMin[i][j] = Math.min(dpMin[i][j],
                                dpMin[i][k] + dpMin[k+1][j] +
                                        matrix_sizes[i][0] *
                                                matrix_sizes[k][1] *
                                                matrix_sizes[j][1]);
                    }


                }

            }

            // for(int i=0; i<n; i++){
            //     System.out.println(Arrays.toString(dpMin[i]));
            // }



            return dpMin[0][n-1];
        }
    }

}
