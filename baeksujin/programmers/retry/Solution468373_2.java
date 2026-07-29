package programmers.retry;
import java.util.*;
public class Solution468373_2 {



    class Solution {

        int n;
        int k;
        int infection;
        ArrayList<int[]> orders;

        // 길이 k의 중복순열 생성 (1,2,3)
        void perm(int[] arr, int depth) {
            if (depth == k) {
                orders.add(arr.clone());
                return;
            }

            for (int i = 1; i <= 3; i++) {
                arr[depth] = i;
                perm(arr, depth + 1);
            }
        }

        public int solution(int n, int infection, int[][] edges, int k) {

            this.n = n;
            this.k = k;
            this.infection = infection;

            // 모든 파이프 여는 순서 생성
            orders = new ArrayList<>();
            perm(new int[k], 0);

            // 그래프 생성 (1-index)
            ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int type = e[2];

                graph.get(u).add(new int[]{v, type});
                graph.get(v).add(new int[]{u, type});
            }

            int answer = 1;

            // 모든 순서에 대해 시뮬레이션
            for (int[] order : orders) {

                boolean[] infected = new boolean[n + 1];
                infected[infection] = true;

                // 행동을 차례대로 수행
                for (int pipeType : order) {

                    Queue<Integer> q = new ArrayDeque<>();

                    // 현재 감염된 모든 노드를 시작점으로 사용
                    for (int i = 1; i <= n; i++) {
                        if (infected[i]) {
                            q.offer(i);
                        }
                    }

                    while (!q.isEmpty()) {
                        int cur = q.poll();

                        for (int[] next : graph.get(cur)) {
                            int nextNode = next[0];
                            int nextType = next[1];

                            if (nextType != pipeType) continue;
                            if (infected[nextNode]) continue;

                            infected[nextNode] = true;
                            q.offer(nextNode);
                        }
                    }
                }

                int cnt = 0;
                for (int i = 1; i <= n; i++) {
                    if (infected[i]) cnt++;
                }

                answer = Math.max(answer, cnt);
            }

            return answer;
        }
    }
}
