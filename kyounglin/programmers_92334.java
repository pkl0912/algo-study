package kyounglin;
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;

        int[] answer = new int[n];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        
        for(String rep: report){
            String[] arr = rep.split(" ");
            Set<String> set = map.getOrDefault(arr[1], new HashSet<>());
            set.add(arr[0]);
            map.put(arr[1], set);
        }
        
        for(String key: map.keySet()){
            if(map.get(key).size()>=k){
                Set<String> set = map.get(key);
                for(String id: set){
                    answerMap.put(id, answerMap.getOrDefault(id, 0)+1);
                }
            }
        }
        for(int i = 0; i<n; i++){
            String id = id_list[i];
            answer[i] = answerMap.getOrDefault(id, 0);
        }
        return answer;
    }
}