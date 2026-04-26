package programmers;
import java.util.*;

class Solution17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0){
            return cities.length * 5;
        }
        ArrayList<String> caches = new ArrayList<>();

        // init cache

        // add remove
        caches.add(cities[0].toLowerCase());
        answer+=5;
        for(int i=1; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(caches.contains(city)){//hit
                answer+=1;
                caches.remove(city);// hit한 숫자 제거
                caches.add(city); // 저장
            }else{
                answer+=5; // miss
                if(caches.size() >= cacheSize){
                    caches.remove(0); // 꽉 찼을 때만 제거
                }
                caches.add(city);
            }



            //System.out.println(caches + " : " + answer);
        }

        return answer;
    }
}