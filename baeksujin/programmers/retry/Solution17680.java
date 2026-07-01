package programmers.retry;

import java.util.*;
public class Solution17680 {

    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            // cacheSize ==0
            if(cacheSize == 0){
                // miss만 존재.
                return cities.length* 5;
            }

            List<String> cache = new ArrayList<>();
            // 대소문자 -> 모두 소문자
            for(int i=0; i<cities.length; i++){
                cities[i] = cities[i].toLowerCase();
            }

            for(int i=0; i<cities.length; i++){

                String current = cities[i];
                // 비어있을 때
                if(cache.size() == 0){
                    answer += 5;
                    cache.add(current);
                    continue;
                }
                // hit -> 가장 최신 사용함을 기록
                if(cache.contains(current)){
                    answer +=1;
                    cache.remove(current);
                    cache.add(current); // 맨 뒤로 배치
                    continue;
                }

                answer +=5;
                // miss -> 꽉 차있다면 제거 +5
                if(cache.size() == cacheSize){
                    // 제일 앞에있는 오랫동안 사용하지 않은 것을 제거
                    cache.remove(0);
                }
                cache.add(current);
            }






            return answer;
        }
    }
}
