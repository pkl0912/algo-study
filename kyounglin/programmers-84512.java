import java.util.*;
class Solution {
    int answer = 0;
    int cnt = -1;
    char[] alpha = new char[]{'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        dfs(new StringBuilder(), word);
        
        return answer;
    }
    public void dfs(StringBuilder sb, String word){
        cnt++;
        if(sb.toString().equals(word)){
            answer = cnt;
            return;
        }
        if(sb.length()==5){
             return;
        }
        
        for(int i = 0; i<5; i++){
            sb.append(alpha[i]);
            dfs(sb, word);
            sb.deleteCharAt(sb.length()-1);
        }
        
        
        
    }
}