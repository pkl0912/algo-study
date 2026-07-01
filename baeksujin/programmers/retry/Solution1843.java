package programmers.retry;
import java.util.*;
public class Solution1843 {



    class Solution {
        public int solution(String arr[]) {
            int answer = -1;

            // (-) : 최대 - (최소의 최대). (+) : 최대 + 최대
            int n = (arr.length +1) / 2;
            int[][] dpMin = new int[n][n];
            int[][] dpMax = new int[n][n];

            //초기값 세팅.

            for(int i=0;i<n;i++){
                Arrays.fill(dpMin[i], Integer.MAX_VALUE);
                Arrays.fill(dpMax[i], Integer.MIN_VALUE);
            }

            for(int i=0; i<n; i++){
                int num = Integer.parseInt(arr[i*2]);
                dpMin[i][i] = num;
                dpMax[i][i] = num;
            }

            for(int len=2; len<=n; len++){
                for(int i=0; i<= n-len; i++){
                    int j=i+len-1;// i에서 Len개만큼 index추가



                    // 연산자
                    for(int m = i; m<j; m++)
                    {

                        String operation = arr[m*2+1];

                        if(operation.equals("+")){
                            dpMin[i][j] = Math.min(dpMin[i][j],
                                    dpMin[i][m] + dpMin[m+1][j]);
                            dpMax[i][j] = Math.max(dpMax[i][j],
                                    dpMax[i][m] + dpMax[m+1][j]);

                        }else{// "-"
                            dpMin[i][j] = Math.min(dpMin[i][j],
                                    dpMin[i][m] - dpMax[m+1][j]);
                            dpMax[i][j] = Math.max(dpMax[i][j],
                                    dpMax[i][m] - dpMin[m+1][j]);


                        }


                    }
                }
            }


            return dpMax[0][n-1];
        }
    }
}
