package programmers;
import java.util.*;

/**
 * 두개의 배열을 합치고 sliding window를 적용.
 * 1개의 배열에 start, end를 두고 이동시키면서 count+=1
 */
public class Solution118667 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {

            int n = queue1.length;
            long sum1 = 0, sum2 = 0;

            for (int x : queue1) sum1 += x;
            for (int x : queue2) sum2 += x;

            long total = sum1 + sum2;

            // 홀수
            if (total % 2 != 0) return -1;

            long target = total / 2;

            // 두 큐를 하나로
            int[] arr = new int[n * 2];
            for (int i = 0; i < n; i++) {
                arr[i] = queue1[i];
                arr[i + n] = queue2[i];
            }

            int left = 0;
            int right = n - 1;

            int count = 0;
            long current = sum1;

            // 최대 이동 횟수 제한 (무한루프 방지)
            int limit = n * 3;

            while (count <= limit) {

                if (current == target) {
                    return count;
                }

                if (current < target) {
                    right++;
                    if (right >= n * 2) return -1;
                    current += arr[right];
                } else {
                    current -= arr[left];
                    left++;
                }

                count++;
            }

            return -1;
        }
    }
}
