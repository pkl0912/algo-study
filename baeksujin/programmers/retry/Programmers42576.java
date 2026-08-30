package programmers.retry;
import java.util.*;

public class Programmers42576 {


    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            // 동명이인 체크 hashMap사용

            Map<String, Integer> participants = new HashMap<>();

            for(String p: participant){

                participants.put(p, participants.getOrDefault(p, 0) + 1);

            }

            for(String c : completion){

                participants.put(c, participants.get(c)-1);
            }


            for(String name : participants.keySet()){

                if(participants.get(name) > 0){
                    return name;
                }
            }




            return answer;
        }
    }
}
