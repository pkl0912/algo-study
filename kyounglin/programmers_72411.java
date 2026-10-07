import java.util.*;

class Solution {
    Map<String, Integer> counter = new HashMap<>();
    public void dfs(int len, String order, StringBuilder sb, int cur){
        if(sb.length()==len){
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String word = new String(arr);
            counter.put(word, counter.getOrDefault(word, 0)+1);
        }
        for(int i = cur; i<order.length(); i++){
            if(!sb.toString().contains(String.valueOf(order.charAt(i)))){
                sb.append(order.charAt(i));
                dfs(len, order, sb, i+1); // cur+1 아니고 i+1
                sb.delete(sb.length()-1, sb.length());
            }
            
        }
    }
    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr); // 정렬 필수
            for(int len :course){
                String sorted = new String(arr); 
                dfs(len, sorted, new StringBuilder(), 0);
            }
            // arr에서 길이 len짜리 조합 뽑아서 counter에 빈도 카운트
        }

        List<String> answer = new ArrayList<>();
        for(int len : course){
            int max = counter.entrySet().stream()
                    .filter(e -> e.getKey().length() == len && e.getValue() >= 2)
                    .mapToInt(Map.Entry::getValue).max().orElse(0);
            for(String key: counter.keySet()){
                if(key.length()==len && counter.get(key)==max) answer.add(key);
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);

        
    }
    
    
}