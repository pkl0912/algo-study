package programmers;
import java.util.*;
public class Solution42576 {
    class Solution {
        public String solution(String[] participant, String[] completion) {

            Map<String, Integer> map1 = new HashMap<>();
            for(String p : participant){

                map1.put(p, map1.getOrDefault(p, 0) + 1);
            }

            for(String c : completion){

                map1.put(c, map1.getOrDefault(c,0) -1);
            }

            for(String key : map1.keySet()){
                if(map1.get(key) != 0){
                    return key;
                }
            }

            return null;
        }
    }
}
