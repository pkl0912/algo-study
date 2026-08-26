package programmers;

import java.util.*;

public class Solution468370 {

    class Solution {
        public int solution(String message, int[][] spoiler_ranges) {
            int answer = 0;

            // 단어 list(" ") -> words
            // 각 단어별 존재하는 개수를 words(map)에 key, value(count++)로 저장
            HashMap<String, Integer> wordCount = new HashMap<>();

            String[] words = message.split(" ");
            for(String w: words){
                wordCount.put(w, wordCount.getOrDefault(w,0)+1);
            }

            int[][] wordsRange = new int[words.length][2];
            int start=0, end=0, cnt = 0;
            for(int i=0; i<message.length(); i++){

                if(message.charAt(i) == ' '){
                    wordsRange[cnt][0] = start;
                    wordsRange[cnt][1] = end;
                    start = end+1;
                    cnt+=1;
                }

                end++;

            }
            wordsRange[words.length-1][0] = start;
            wordsRange[words.length-1][1] = end;

            // spoiler check
            boolean[] visited = new boolean[message.length()+1];
            for(int i=0; i<spoiler_ranges.length; i++){
                int[] spo = spoiler_ranges[i];
                for(int j=spo[0]; j<spo[1]+1; j++){
                    visited[j] = true;
                }
            }

            //System.out.println(Arrays.toString(visited));

            // words에서 스포일러에 해당하는 값을 spo 맵에 저장.
            HashMap<String, Integer> spolierCount = new HashMap<>();
            List<String> s = new ArrayList<>();
            int n = words.length;
            for(int i=0; i<n; i++){
                String currentWord = words[i];
                int currentWordStart = wordsRange[i][0];
                int currentWordEnd= wordsRange[i][1];
                //System.out.println(currentWordStart + " ~ " + currentWordEnd);

                for(int j=currentWordStart; j<currentWordEnd; j++){

                    if(visited[j]){
                        //System.out.println(currentWord + "!");
                        s.add(currentWord);
                        spolierCount.put(currentWord, spolierCount.getOrDefault(currentWord,0)+1);
                        wordCount.put(currentWord, wordCount.get(currentWord)-1);
                        break; // 다음 단어를
                    }
                }

            }


            int count = 0;
            HashSet<String> before = new HashSet<>();



            for(String current : s){
                if( before != null && before.contains(current)){

                    continue;
                }


                if(wordCount.get(current) !=0){
                    continue;
                }

                //System.out.println(current);
                before.add(current);
                count+=1;
            }

            return count;
        }
    }
}
