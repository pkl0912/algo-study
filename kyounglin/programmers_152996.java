import java.util.*;

class Solution {
    public long solution(int[] w) {
        long answer = 0;  
        
        Arrays.sort(w);
        HashMap<Double,Integer> map = new HashMap<>();
        
        for(int i = 0; i<w.length; i++){
            double[] targets = {w[i] *1.0, w[i] * 0.5, (w[i] * 2.0)/3.0 ,w[i] * 0.75};
            
            for(double t : targets){
                if(map.containsKey(t)) answer += map.get(t);
            }
            
            if(map.containsKey(w[i]*1.0)){
                map.put(w[i]*1.0, map.get(w[i]*1.0) + 1);
            }else{
                map.put(w[i]*1.0 , 1);
            }
        }
        
        return answer;
    }
}