package programmers.retry;

import java.util.Arrays;

public class Solution42884 {


    class Solution {
        public int solution(int[][] routes) {
            int answer = 0;


            // e를 기준으로 정렬 ( 맨앞 cctv는 무조건 설치.뒤에 놓을수록 다음과 겹칠확ㄱ률이높아짐)
            Arrays.sort(routes, (a, b) -> a[1] -b[1]);

            int c = routes[0][1];
            answer +=1;

            for(int i=1; i<routes.length; i++){

                int s = routes[i][0];
                if(s <= c){ // pass 설치 x = 구간겹침
                    continue;
                }
                answer+=1;
                c = routes[i][1]; // 새로운 구간. 설치
            }

            return answer;
        }
    }
}
