package programmers.retry;
import java.util.*;
public class Solution43163 {
    class Solution {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            Deque<String> queue = new ArrayDeque<>();
            Deque<Integer> queueCount = new ArrayDeque<>();

            queue.offer(begin);
            queueCount.offer(0);
            int n = words.length;
            int len = words[0].length();
            boolean[] visited = new boolean[n];


            while(!queue.isEmpty()){

                String current = queue.poll();
                int currentCount = queueCount.poll();
                // System.out.println(current);

                if(current.equals(target)) return currentCount;

                for(int i=0; i<n; i++){
                    String word = words[i];
                    int count = 0;

                    if(visited[i] == true) continue;
                    for(int j=0; j<len; j++){
                        if(word.charAt(j) == current.charAt(j)){
                            count+=1;
                        }
                    }

                    if(count == (len-1)){
                        // push
                        queue.offer(word);
                        queueCount.offer(currentCount+1);
                        visited[i] = true;
                    }

                }


            }



            return answer;
        }
    }
}
