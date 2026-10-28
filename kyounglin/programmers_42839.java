import java.util.*;

class Solution {
    public Set<String> set = new HashSet<>();
    public int solution(String numbers) {
        dfs(0, new StringBuilder(), numbers);
        return set.size();
    }
    public void dfs(int idx, StringBuilder sb, String numbers){
        if(idx==numbers.length()){
            if(sb.length()!=0){
                String num = sb.toString();
                if(!set.contains(num)){
                    set.add(num);
                }
            }
            
            return;
        }
        System.out.println(sb.toString());
        for(int i = 0; i<numbers.length(); i++){
            dfs(idx+1, sb.append(numbers.charAt(i)), numbers);
            dfs(idx+1, sb, numbers);
        }
    }
}