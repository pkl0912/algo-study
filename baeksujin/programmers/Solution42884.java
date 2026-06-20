package programmers;

import java.util.Arrays;

public class Solution42884 {

    class Solution {
        public int solution(int[][] routes) {
            int answer = 0;

            // 오름차순으로 정렬
            Arrays.sort(routes, (a, b) -> a[1] -b[1]);


            int camera = Integer.MIN_VALUE;

            for (int[] route : routes) {
                int start = route[0];
                int end = route[1];

                // 카메라가 이 차를 못 잡으면
                if (camera < start) {
                    answer++;
                    camera = end;
                }
            }

            return answer;
        }
    }


}
