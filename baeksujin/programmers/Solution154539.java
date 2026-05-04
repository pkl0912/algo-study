package programmers;
import java.util.*;
public class Solution154539 {


    class Solution {
        public int[] solution(int[] numbers) {
            int n = numbers.length;
            int[] answer = new int[n];
            Arrays.fill(answer, -1); // 기본값

            Stack<Integer> stack = new Stack<>(); // 인덱스 저장

            for (int i = 0; i < n; i++) {

                // 현재 값이 더 크면 이전 값들 해결
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    int idx = stack.pop();
                    answer[idx] = numbers[i];
                }

                stack.push(i);
            }

            return answer;
        }
    }
}
