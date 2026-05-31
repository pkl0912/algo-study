package programmers;

public class Solution161988 {

    class Solution {
        public long solution(int[] sequence) {
            int n = sequence.length;

            long answer = Long.MIN_VALUE;

            long sum1 = 0; // pulse1 누적합
            long sum2 = 0; // pulse2 누적합

            long min1 = 0;
            long min2 = 0;

            for (int i = 0; i < n; i++) {
                int sign1 = (i % 2 == 0) ? 1 : -1;
                int sign2 = -sign1;

                sum1 += sequence[i] * sign1; // 지금까지의 합
                sum2 += sequence[i] * sign2;

                answer = Math.max(answer, sum1 - min1); // 현재 -최소 = 최대
                answer = Math.max(answer, sum2 - min2);

                min1 = Math.min(min1, sum1); // 지금까지의 sum과 여태 sum중 최소를 구하기
                min2 = Math.min(min2, sum2);
            }

            return answer;
        }
    }
}
