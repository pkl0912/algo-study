package programmers.retry;

public class Solution43238 {

    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            // 심사 받는데 껄리는 최솟값 -> 심사 시간 target

            int N = times.length;
            int max = 0;
            for(int i=0; i<N; i++){
                max = Math.max(max, times[i]);
            }

            long start = 1, end = (long)max*n;


            while(start <= end){

                long time = (start + end) / 2;

                // answer 시간으로 최대 병렬 몇명 가능한지 확인
                long count = 0;
                for(int i=0; i<N; i++){
                    count += time / times[i];
                }

                if(count < n){ // 처리가능한 count(인원수)를 늘려야함. answer를 +
                    start = time+1;
                }else{
                    // 처리가능 n명
                    answer = time;
                    end = time -1;
                }


            }

            return answer;
        }
    }
}
