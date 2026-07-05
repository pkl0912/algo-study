import java.util.*;

class Solution {
    public int n;
    public int[] info;
    public List<Integer> arr = new ArrayList<>();
    public int maxDiff = 0; 

    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        int[] answer = new int[11]; 

        dfs(0, 0, new ArrayList<>());

        if (arr.isEmpty()) return new int[]{-1};

        int used = 0;
        for (int index : arr) {
            answer[index] = info[index] + 1;
            used += info[index] + 1;
        }

        answer[10] += n - used;

        return answer;
    }

    public void dfs(int start, int arrowCnt, List<Integer> indexes) {
        if (arrowCnt > n) return;

        if (start == 11 || arrowCnt == n) {

            int lionScore = 0, peachScore = 0;
            for (int i = 0; i <= 9; i++) {
                int score = 10 - i; 
                if (indexes.contains(i)) {
                    lionScore += score; 
                } else if (info[i] > 0) {
                    peachScore += score; 
                }
            }

            int diff = lionScore - peachScore;

            if (diff > maxDiff) {
                maxDiff = diff;
                arr = new ArrayList<>(indexes);
            } else if (diff == maxDiff && diff > 0) {

                for (int i = 9; i >= 0; i--) {
                    boolean curHas = indexes.contains(i);
                    boolean bestHas = arr.contains(i);
                    if (curHas != bestHas) {
                        if (curHas) arr = new ArrayList<>(indexes); 
                        break;
                    }
                }
            }
            return;
        }

        if (arrowCnt + info[start] + 1 <= n) {
            indexes.add(start);
            dfs(start + 1, arrowCnt + info[start] + 1, indexes);
            indexes.remove(indexes.size() - 1);
        }

        // i번 점수 포기
        dfs(start + 1, arrowCnt, indexes);
    }
}