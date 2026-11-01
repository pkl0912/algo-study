
import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int m = cores.length;

        long left = 0;
        long right = (long) n * Arrays.stream(cores).min().getAsInt();

        while (left < right) {
            long mid = left + (right - left) / 2;

            long count = m;

            for (int core : cores) {
                count += mid / core;
            }

            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long time = left;

        long count = m;

        for (int core : cores) {
            count += (time - 1) / core;
        }

        for (int i = 0; i < m; i++) {
            if (time % cores[i] == 0) {
                count++;

                if (count == n) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}
