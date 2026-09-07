package leetcode;

import java.util.*;
public class Solution2132680559 {
    class Solution {
        public final int Max = 10001;

        public int coinChange(int[] coins, int amount) {

            int[][] array = new int[coins.length + 1][amount + 1];

            // i=0: 동전을 아예 안 쓴 상태 → 금액 0만 0개, 나머지는 불가능
            for (int j = 0; j <= amount; j++) {
                array[0][j] = (j == 0) ? 0 : Max;
            }

            for (int i = 1; i <= coins.length; i++) {
                int coin = coins[i - 1];
                for (int j = 0; j <= amount; j++) {
                    array[i][j] = array[i - 1][j];
                    if (j >= coin && array[i][j - coin] + 1 < array[i][j]) {
                        array[i][j] = array[i][j - coin] + 1;
                    }
                }
            }

            int result = array[coins.length][amount];
            return result >= Max ? -1 : result;
        }
    }
}
