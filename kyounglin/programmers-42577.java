package kyounglin;

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map =new HashMap<>();
        Set<Integer> len = new HashSet<>();
        Arrays.sort(phone_book);
        for(String s : phone_book){
            len.add(s.length());
        }
        for(String s : phone_book){
            for(int l: len){
                if(l<s.length()){
                    String sub = s.substring(0,l);
                    map.put(sub, map.getOrDefault(sub, 0)+1);
                }else break;
            }
        }
        for(String s: phone_book){
            if(map.getOrDefault(s, 0)!=0) answer = false;
        }
        
        return answer;
    }
}