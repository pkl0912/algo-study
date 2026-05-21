package programmers;
import java.util.*;

public class Solution42627 {
    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int now = 0;
            int i = 0;
            int start = -1;

            // 소요시간 기준 최소 힙
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> a[0] - b[0]   // a[0] = 실행시간
            );

            while (i < jobs.length) {// 다 끝날때까지 진행

                // 현재 시간까지 들어온 작업 넣기
                for (int j = 0; j < jobs.length; j++) {
                    // tip) 다른사람 풀이를 보니, 전체 탐색을 진행하지 않고 jobs를 들어온 시간기준으로 정렬하고 now보다 jobs[i][o]이 작거나 같을 때로 while의 조건을 둠. -> 시간절약가능
                    if (start < jobs[j][0] && jobs[j][0] <= now) {
                        pq.offer(new int[]{jobs[j][1], jobs[j][0]});
                    }
                }

                if (!pq.isEmpty()) {
                    int[] current = pq.poll();

                    start = now;
                    now += current[0]; // 실행시간 - 현재job 완료했다고 생각하며 실행시간 누적
                    answer += (now - current[1]); // 반환시간 - 누적실행시간에서 job이 들어온시간을 빼면 기다린 시간이됨. (반환시간)

                    i++;
                } else {
                    now++; // 현재까지 사이에 실행가능한 job이 없다면 다음시간으로 넘김
                }
            }

            return answer / jobs.length; // 평균
        }
    }

}
