package programmers;
import java.util.*;

public class Solution67257 {
    class Solution {
        public long solution(String expression) {
            // 1. 숫자 / 연산자 분리
            List<Long> numbers = new ArrayList<>();
            List<Character> operators = new ArrayList<>();

            String num = "";
            for (char c : expression.toCharArray()) {
                if (c == '+' || c == '-' || c == '*') {
                    numbers.add(Long.parseLong(num));
                    operators.add(c);
                    num = "";
                } else {
                    num += c;
                }
            }
            numbers.add(Long.parseLong(num));

            // 2. 우선순위 고정 6가지
            char[][] priority = {
                    {'+', '-', '*'},
                    {'+', '*', '-'},
                    {'-', '+', '*'},
                    {'-', '*', '+'},
                    {'*', '+', '-'},
                    {'*', '-', '+'}
            };

            long answer = 0;

            // 모든 우선순위 돌면서 탐색 진행
            for (char[] order : priority) {

                List<Long> nums = new ArrayList<>(numbers);
                List<Character> ops = new ArrayList<>(operators);

                // 4. 우선순위대로 연산 수행
                for (char op : order) {
                    for (int i = 0; i < ops.size(); ) {// 연산자를 하나씩 제거하면서 계산.
                        if (ops.get(i) == op) {
                            long result = calc(nums.get(i), nums.get(i + 1), op);

                            // 리스트 줄이기
                            nums.remove(i);
                            nums.remove(i);
                            nums.add(i, result);

                            ops.remove(i);
                        } else {
                            i++;
                        }
                    }
                }

                answer = Math.max(answer, Math.abs(nums.get(0)));
            }

            return answer;
        }

        private long calc(long a, long b, char op) {
            if (op == '+') return a + b;
            if (op == '-') return a - b;
            return a * b;
        }
    }
}
