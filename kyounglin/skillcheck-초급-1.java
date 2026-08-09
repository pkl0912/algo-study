package kyounglin;
import java.util.*;
class Solution {
    long answer = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public long solution(int[] weights) {
        Arrays.sort(weights);
        for(int w: weights){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        
        for(int key: map.keySet()){
            long cnt = map.get(key); 
            answer += cnt*(cnt-1)/2;  
        }
        for(int num: map.keySet()){
            answer += getRatio(4, 3, num);
            answer += getRatio(2, 1, num);
            answer += getRatio(3, 2, num);
        }
        
        return answer;
    }
    
    public long getRatio(int a, int b, int num){
        
        long answer = 0;
        if(num % a == 0){
            long partnerCount = map.getOrDefault(num/a*b, 0); 
            long numCount = map.get(num);
            answer += partnerCount * numCount; 
            System.out.println(a+" "+b+" "+num);
        }
        return answer;
    }
}