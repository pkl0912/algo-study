package programmers;

public class Solution12985 {

    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;

            // 2 - 1 / 3 - 2
            while (a != b) {
                a = (a + 1) / 2;
                b = (b + 1) / 2;
                answer++;
            }

            return answer;
        }
    }


}
