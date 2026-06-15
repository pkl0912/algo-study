package programmers;

public class Solution1843 {

    class Solution {
        public int solution(String[] arr) {
            int n = (arr.length + 1) / 2; // 숫자 개수

            int[][] dpMax = new int[n][n];
            int[][] dpMin = new int[n][n];

            // 초기값 세팅
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(arr[i * 2]);
                dpMax[i][i] = num;
                dpMin[i][i] = num;
            }

            // 구간 길이
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    // System.out.println(len + "."+ i +"."+ j);

                    dpMax[i][j] = Integer.MIN_VALUE;
                    dpMin[i][j] = Integer.MAX_VALUE;

                    // 연산자 (연산자 기준으로, 앞 뒤)
                    // i~j(len개 사이의 연산결과를 저장)
                    for (int k = i; k < j; k++) { // k번째를 기준으로 spilt
                        String op = arr[k * 2 + 1];
                        // System.out.println("i : "+i + "j : " + j + "k : "+ k);

                        if (op.equals("+")) {
                            dpMax[i][j] = Math.max(dpMax[i][j],
                                    dpMax[i][k] + dpMax[k + 1][j]);

                            dpMin[i][j] = Math.min(dpMin[i][j],
                                    dpMin[i][k] + dpMin[k + 1][j]);
                        } else { // "-"
                            dpMax[i][j] = Math.max(dpMax[i][j],
                                    dpMax[i][k] - dpMin[k + 1][j]);

                            dpMin[i][j] = Math.min(dpMin[i][j],
                                    dpMin[i][k] - dpMax[k + 1][j]);
                        }
                    }
                }
            }

            return dpMax[0][n - 1];
        }
    }
}
