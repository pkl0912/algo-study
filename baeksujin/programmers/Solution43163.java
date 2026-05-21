package programmers;

import java.util.*;

public class Solution43163 {

    class Solution {
        public int solution(String begin, String target, String[] words) {

            Deque<String[]> dq = new ArrayDeque<>();
            dq.offer(new String[]{begin, "0"});

            boolean[] visited = new boolean[words.length];
            int size = target.length();

            while (!dq.isEmpty()) {

                String[] temp = dq.poll();
                String current = temp[0];
                int depth = Integer.parseInt(temp[1]);

                if (current.equals(target)) {
                    return depth;
                }

                for (int i = 0; i < words.length; i++) {

                    if (!visited[i]) {

                        int sameSize = 0;

                        for (int j = 0; j < size; j++) {
                            if (words[i].charAt(j) == current.charAt(j)) {
                                sameSize++;
                            }
                        }

                        // 한 글자만 다른 경우
                        if (sameSize == size - 1) {
                            dq.offer(new String[]{words[i], String.valueOf(depth + 1)});
                            visited[i] = true;
                        }
                    }
                }
            }

            return 0;
        }
    }
}
