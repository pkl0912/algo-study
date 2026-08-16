package programmers;
import java.util.*;
public class Solution43164 {

    class Solution {
        String[][] tickets;
        boolean[] used;
        List<String> answer;
        int n;

        public String[] solution(String[][] tickets) {
            this.tickets = tickets;
            this.n = tickets.length;
            this.used = new boolean[n];
            this.answer = new ArrayList<>();

            // 도착지 기준 사전순 정렬 -> 같은 출발지끼리는 도착지가 작은 순으로 먼저 시도됨
            Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

            List<String> path = new ArrayList<>();
            path.add("ICN");
            dfs("ICN", path);

            return answer.toArray(new String[0]);
        }

        private boolean dfs(String current, List<String> path) {
            if (path.size() == n + 1) {
                answer = new ArrayList<>(path);
                return true; // 모든 티켓을 다 쓴 경로 완성
            }

            for (int i = 0; i < n; i++) {
                if (used[i]) continue;
                if (!tickets[i][0].equals(current)) continue;

                used[i] = true;
                path.add(tickets[i][1]);

                if (dfs(tickets[i][1], path)) {
                    return true; // 성공하면 더 탐색 안 하고 바로 리턴 (사전순 첫 정답이 최적)
                }

                // 실패하면 백트래킹
                path.remove(path.size() - 1);
                used[i] = false;
            }

            return false;
        }
    }
}
