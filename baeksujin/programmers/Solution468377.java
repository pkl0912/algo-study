package programmers;

public class Solution468377 {

    class Solution {
        public int solution(int[][] cost, int[][] hint) {

            int stageN = cost.length;
            int minValue = Integer.MAX_VALUE;

            for (int mask = 0; mask < (1 << stageN-1); mask++) {

                int[] stageHint = new int[stageN];
                int currentCost = 0;

                for (int i = 0; i < stageN; i++) {

                    int minCost = cost[i][0];

                    for (int j = 1; j < cost[i].length; j++) {
                        if (stageHint[i] >= j) {
                            minCost = Math.min(minCost, cost[i][j]);
                        }
                    }

                    currentCost += minCost;

                    if ((mask & (1 << i)) != 0) {

                        currentCost += hint[i][0];

                        for (int j = 1; j < hint[i].length; j++) {
                            stageHint[hint[i][j] - 1]++;
                        }
                    }
                }

                minValue = Math.min(minValue, currentCost);
            }

            return minValue;
        }
    }

}
