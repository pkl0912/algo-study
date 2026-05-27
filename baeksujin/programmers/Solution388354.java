package programmers;
import java.util.*;

public class Solution388354 {


    class Solution {
        public int[] solution(int[] nodes, int[][] edges) {

            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, Integer> degree = new HashMap<>();

            for (int node : nodes) {
                graph.put(node, new ArrayList<>());
                degree.put(node, 0);
            }

            for (int[] e : edges) {
                int a = e[0];
                int b = e[1];

                graph.get(a).add(b);
                graph.get(b).add(a);

                degree.put(a, degree.get(a) + 1);
                degree.put(b, degree.get(b) + 1);
            }

            Set<Integer> visited = new HashSet<>();

            int evenOddTree = 0;
            int reverseTree = 0;

            for (int node : nodes) {
                if (visited.contains(node)) continue;

                // 컴포넌트 탐색
                Queue<Integer> q = new LinkedList<>();
                q.offer(node);
                visited.add(node);

                int count1 = 0; // 홀짝 -> parity가 다른게 1개만 존재해야함.
                int count0 = 0; // 역홀짝 -> parity가 다른게 1개만 존재해야함.

                while (!q.isEmpty()) {
                    int cur = q.poll();

                    int nodeParity = cur % 2;
                    int degParity = degree.get(cur) % 2;

                    if (nodeParity == degParity) count1++;
                    else count0++;

                    for (int next : graph.get(cur)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }

                // 처음에 이중for문으로 탐색 -> 루트노드 수가 1개를 만족하는지 확인함으로써 시간단축.
                // 홀짝 트리일 때 루트 조건을 만족하는게 1개여야함. 루트가 2개일수없으니.
                if (count1 == 1) evenOddTree++;
                // 역홀짝 트리일 때 루트 조건을 만족하는 노트가 1개여야함.
                if (count0 == 1) reverseTree++;
            }

            return new int[]{evenOddTree, reverseTree};
        }
    }
}
