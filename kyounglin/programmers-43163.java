package kyounglin;

import java.util.*;

class Solution {
    public int answer = 0;
    public Map<String, Integer> map = new HashMap<>();
    public int solution(String begin, String target, String[] words) {
        boolean isPossible = false;
        for(String word: words){
            if(target.equals(word)) isPossible = true;
        }
        if(!isPossible) return 0;
        
        for(int i = 0; i<words.length; i++){
            map.put(words[i], i);
        }
        
        bfs(begin, target, words);
        return answer;
    }
    public void bfs(String begin, String target, String[] words){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{map.getOrDefault(begin, -1), 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            String curWord = cur[0]==-1? begin : words[cur[0]];
            int dist = cur[1];
            if(curWord.equals(target)){
                answer = dist;
                return;
            }
            for(String word: words){
                if(isOneDiff(curWord, word)){
                    q.add(new int[]{map.get(word), dist+1});
                }
            }
            
        }
    }
    public boolean isOneDiff(String aWord, String bWord){
        int cnt = 0;
        for(int i = 0; i<aWord.length(); i++){
            if(cnt>1) return false;
            if(aWord.charAt(i)!= bWord.charAt(i)) cnt++;
        }
        if(cnt==1) return true;
        else return false;
    }
}