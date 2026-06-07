package programmers;

import java.util.*;

/**
 * 다시 풀어보기
 */
public class Solution468380 {

    class Solution {
        public long[] solution(int[] arr, long l, long r) {
            int n = arr.length;

            // 1. 누적 길이 / 누적 합
            long[] len = new long[n];
            long[] sum = new long[n];

            for (int i = 0; i < n; i++) {
                long count = arr[i];
                long total = (long) arr[i] * arr[i];

                if (i == 0) {
                    len[i] = count;
                    sum[i] = total;
                } else {
                    len[i] = len[i - 1] + count;
                    sum[i] = sum[i - 1] + total;
                }
            }

            // 2. K 구하기
            long K = getPrefixSum(len, sum, arr, r)
                    - getPrefixSum(len, sum, arr, l - 1);

            // 3. C 구하기
            long windowSize = r - l + 1;
            long C = countWindow(arr, windowSize, K);

            return new long[]{K, C};
        }

        // prefix sum
        private long getPrefixSum(long[] len, long[] sum, int[] arr, long k) {
            if (k <= 0) return 0;

            int idx = Arrays.binarySearch(len, k);

            if (idx >= 0) return sum[idx];

            idx = -idx - 1;

            long prevSum = (idx > 0) ? sum[idx - 1] : 0;
            long prevLen = (idx > 0) ? len[idx - 1] : 0;

            long remain = k - prevLen;

            return prevSum + remain * arr[idx];
        }


        private long countWindow(int[] arr, long windowSize, long K) {
            int n = arr.length;

            int lIdx = 0, rIdx = 0;
            long lOffset = 0, rOffset = 0;

            long curSum = 0;
            long curLen = 0;
            long count = 0;

            while (true) {

                // window 채우기
                if (curLen < windowSize) {
                    if (rIdx == n) break;

                    long canTake = Math.min(
                            arr[rIdx] - rOffset,
                            windowSize - curLen
                    );

                    curSum += canTake * arr[rIdx];
                    curLen += canTake;
                    rOffset += canTake;

                    if (rOffset == arr[rIdx]) {
                        rIdx++;
                        rOffset = 0;
                    }
                }

                // window 유지 + 이동
                else {
                    // 현재 window 체크
                    if (curSum == K) count++;

                    // 점프 여부 결정
                    long jump = 1;

                    if (rIdx < n && arr[lIdx] == arr[rIdx]) {
                        long maxJump = Math.min(
                                arr[lIdx] - lOffset,
                                arr[rIdx] - rOffset
                        );

                        // 같은 값이면 여러 개 한 번에 count 가능
                        if (curSum == K) {
                            count += (maxJump - 1); // 이미 1개 셌으므로 -1
                        }

                        jump = maxJump;
                    }

                    // 왼쪽 제거
                    curSum -= jump * arr[lIdx];
                    curLen -= jump;
                    lOffset += jump;

                    if (lOffset == arr[lIdx]) {
                        lIdx++;
                        lOffset = 0;
                    }

                    // 오른쪽 추가
                    if (rIdx == n) break;

                    curSum += jump * arr[rIdx];
                    curLen += jump;
                    rOffset += jump;

                    if (rOffset == arr[rIdx]) {
                        rIdx++;
                        rOffset = 0;
                    }
                }
            }

            return count;
        }
    }
}
