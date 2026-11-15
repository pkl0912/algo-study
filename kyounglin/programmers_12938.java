
class Solution {
    public int[] solution(int n, int s) {

        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        int quotient = s / n;

        int remainder = s % n;

        for (int i = 0; i < n; i++) {
            answer[i] = quotient;

            if (i >= n - remainder) {
                answer[i]++;
            }
        }

        return answer;
    }
}
