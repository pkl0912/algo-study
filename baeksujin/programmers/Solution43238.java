package programmers;
import java.util.*;

public class Solution43238 {


    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            // time기준으로 정답을 탐색진행.

            Arrays.sort(times);

            long start = 1;
            long end = (long)n*times[times.length-1];
            answer = end;

            while(start <= end){
                long mid = (start + end)/2;

                // 몫 - time으로 몇명 처리가능한지 구하기
                long currentN = 0;
                for(int t : times){
                    currentN += mid/t;
                }

                // 처리가능한 인원을 N과 비교
                if(n <= currentN){ // time을 줄이기
                    answer = mid; //더 줄일 수 없다면 지금 값이 그냥 return
                    end = mid-1;
                }else{
                    start = mid+1;
                }


            }

            return answer;
        }
    }
}
