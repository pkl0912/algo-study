package programmers.retry;
import java.util.*;
public class Solution42627 {


    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int now = 0;
            int i=0;
            int start = -1;

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a,b) -> a[1]-b[1]    // 작업 소요시간이 짧은 것.
            );// 요청시각: a[0] - b[0];

            while (i < jobs.length) {

                // 현재 시간까지 들어온 작업 넣기
                for (int j = 0; j < jobs.length; j++) {
                    if (start < jobs[j][0] && jobs[j][0] <= now) {
                        pq.offer(new int[]{jobs[j][0], jobs[j][1]});
                    }
                }

                if (!pq.isEmpty()) {
                    int[] current = pq.poll();

                    start = now;
                    now += current[1]; // 실행시간
                    answer += (now - current[0]); // 반환시간

                    i++;
                } else {
                    now++;
                }
            }

            return answer / jobs.length;

        }
    }
}
