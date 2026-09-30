import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {

        int n = onboard.length;

        int minTemp = Math.min(temperature, t1);
        int maxTemp = Math.max(temperature, t2);

        int INF = Integer.MAX_VALUE / 2;

        int[][] dp = new int[n][maxTemp - minTemp + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][temperature - minTemp] = 0;

        for (int i = 1; i < n; i++) {

            for (int temp = minTemp; temp <= maxTemp; temp++) {

                int prev = dp[i - 1][temp - minTemp];

                if (prev == INF) continue;


                //off
                int nextOff;

                if (temp < temperature) {
                    nextOff = temp + 1;
                } else if (temp > temperature) {
                    nextOff = temp - 1;
                } else {
                    nextOff = temp;
                }

                if (isPossible(nextOff, i, t1, t2, onboard)) {
                    dp[i][nextOff - minTemp] =
                            Math.min(
                                    dp[i][nextOff - minTemp],
                                    prev
                            );
                }


                //on

                // temp - 1
                int next = temp - 1;

                if (next >= minTemp &&
                        isPossible(next, i, t1, t2, onboard)) {

                    dp[i][next - minTemp] =
                            Math.min(
                                    dp[i][next - minTemp],
                                    prev + a
                            );
                }


                // temp 유지
                next = temp;

                if (isPossible(next, i, t1, t2, onboard)) {

                    dp[i][next - minTemp] =
                            Math.min(
                                    dp[i][next - minTemp],
                                    prev + b
                            );
                }


                // temp + 1
                next = temp + 1;

                if (next <= maxTemp &&
                        isPossible(next, i, t1, t2, onboard)) {

                    dp[i][next - minTemp] =
                            Math.min(
                                    dp[i][next - minTemp],
                                    prev + a
                            );
                }
            }
        }

        int answer = INF;

        for (int temp = minTemp; temp <= maxTemp; temp++) {
            answer = Math.min(
                    answer,
                    dp[n - 1][temp - minTemp]
            );
        }

        return answer;
    }


    private boolean isPossible(
            int temp,
            int time,
            int t1,
            int t2,
            int[] onboard
    ) {
        if (onboard[time] == 1) {
            return t1 <= temp && temp <= t2;
        }

        return true;
    }
}