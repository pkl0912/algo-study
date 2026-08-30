package programmers.retry;
import java.util.*;
public class Solution49189 {
    class Solution {
        public int solution(int n, int[][] edge) {
            ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int[] e : edge) {
                nodes.get(e[0]).add(e[1]);
                nodes.get(e[1]).add(e[0]);
            }

            // 거리(cost) -> 해당 거리를 가진 노드 개수
            HashMap<Integer, Integer> nodeCost = new HashMap<>();

            Deque<int[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            visited[1] = true;
            queue.offer(new int[]{1, 0});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentNode = current[0];
                int currentCost = current[1];

                nodeCost.put(currentCost, nodeCost.getOrDefault(currentCost, 0) + 1);

                for (int next : nodes.get(currentNode)) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    queue.offer(new int[]{next, currentCost + 1});
                }
            }

            int max = -1;
            for (int key : nodeCost.keySet()) {
                max = Math.max(key, max);
            }

            return nodeCost.get(max);
        }
    }
}
