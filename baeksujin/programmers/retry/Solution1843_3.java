package programmers.retry;
import java.util.*;

public class Solution1843_3 {


    class Solution {
        public int solution(String arr[]) {
            int answer = -1;

            // dpMin : dpMin - dpMax / dpMin + dpMin
            // dpMax : dpMax + dpMax / dpMax - dpMin

            int n = (arr.length + 1) / 2;
            int[][] dpMin = new int[n][n];
            int[][] dpMax = new int[n][n];

            // init
            for(int i=0; i<n; i++){
                Arrays.fill(dpMin[i], Integer.MAX_VALUE);
                Arrays.fill(dpMax[i], Integer.MIN_VALUE);
                int num = Integer.parseInt(arr[i*2]);
                dpMin[i][i] = num;
                dpMax[i][i] = num;
            }

            for(int l = 2; l<=n; l++){// 숫자의 개수
                for(int i=0; i<=n-l; i++){

                    int j= i + l -1;
                    for(int k= i; k<j; k++){

                        String oper = arr[k*2+1];

                        if(oper.equals("+")){
                            dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + dpMin[k+1][j]);
                            dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + dpMax[k+1][j]);
                        }else{
                            dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] - dpMax[k+1][j]);
                            dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] - dpMin[k+1][j]);
                        }

                    }
                }
            }

            // for(int i=0; i<n; i++){
            //     System.out.println(Arrays.toString(dpMax[i]));
            // }

            return dpMax[0][n-1];
        }
    }
}
