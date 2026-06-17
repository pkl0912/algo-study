package programmers;

public class Solution12904 {

    class Solution
    {
        public int solution(String s)
        {
            int answer = 0;

            // 중간에 있는 것들에 대해서 활용하면서 탐색.
            // 길이를 적은것부터 순차적으로 탐색 -> 2차원으로 넣어놔야함.

            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int max = 1;
            if(s.length() == 1){
                return max;
            }

            // 길이 1
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            // 길이 2 이상
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;

                    if (s.charAt(i) == s.charAt(j)) {
                        if (len == 2 || dp[i+1][j-1]) {
                            dp[i][j] = true;
                            max = Math.max(max, len) // 안의 문자열이 true일때는 현재와 끝이 동일하다면 팰린드롬 문자열임
                        }
                    }
                }
            }

            return max;
        }
    }
}
