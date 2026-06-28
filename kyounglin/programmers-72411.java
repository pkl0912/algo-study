package kyounglin;

import java.util.*;

class Solution {
    public Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> arr = new ArrayList<>();
        for(int c: course){
            map.clear();
            
            for(String order: orders){
                dfs(order, 0, c, new StringBuilder());
            }
            int max = 0;
            for(int v : map.values()){
                max = Math.max(max, v);
            }
            if(max>=2){
                for(String k: map.keySet()){
                    if(map.get(k)==max) arr.add(k);
                }
            }
            
        }
        
        Collections.sort(arr);
        return arr.toArray(new String[0]);
    }
    public void dfs(String order, int start, int cnt, StringBuilder sb){
        if(sb.length()==cnt){
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0)+1);
            return;
        }
        for(int i = start; i<order.length(); i++){
            sb.append(order.charAt(i));
            dfs(order, i+1, cnt, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}