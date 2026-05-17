package kyounglin;

import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int max = 0;
        for (int node : nodes) max = Math.max(max, node);

        List<Integer>[] graph = new ArrayList[max + 1];
        for (int i = 0; i <= max; i++) graph[i] = new ArrayList<>();

        Set<Integer> nodeSet = new HashSet<>();
        for (int node : nodes) nodeSet.add(node);

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[max + 1];
        int holjak = 0, reverse = 0;

        for (int node : nodes) {
            if (visited[node]) continue;

            Map<Integer, Integer> childCount = new HashMap<>();
            Map<Integer, Integer> parent = new HashMap<>();
            List<Integer> bfsOrder = new ArrayList<>();

            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            visited[node] = true;
            parent.put(node, -1);

            while (!q.isEmpty()) {
                int cur = q.poll();
                bfsOrder.add(cur);
                int cnt = 0;
                for (int next : graph[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        parent.put(next, cur);
                        q.add(next);
                        cnt++;
                    }
                }
                childCount.put(cur, cnt);
            }

            if (bfsOrder.size() == 1) {
                int v = bfsOrder.get(0);
                if (v % 2 == 0) holjak++;  
                else reverse++;            
                continue;
            }

            Map<Integer, Integer> degree = new HashMap<>();
            for (int v : bfsOrder) {
                degree.put(v, graph[v].size());
            }


            int totalNodes = bfsOrder.size();
            int matchCount = 0;   
            int mismatchCount = 0; 

            for (int v : bfsOrder) {
                int childIfNotRoot = degree.get(v) - 1;
                if (v % 2 == childIfNotRoot % 2) matchCount++;
                else mismatchCount++;
            }

            int holjakCount = 0, reverseCount = 0;

            for (int r : bfsOrder) {
                int childIfNotRoot = degree.get(r) - 1;
                int childIfRoot = degree.get(r);

                boolean wasMatch = (r % 2 == childIfNotRoot % 2);
                boolean isMatchAsRoot = (r % 2 == childIfRoot % 2);

                int curMatch = matchCount;
                int curMismatch = mismatchCount;

                if (wasMatch) curMatch--;
                else curMismatch--;

                if (isMatchAsRoot) curMatch++;
                else curMismatch++;

                if (curMatch == totalNodes) holjakCount++;
                if (curMismatch == totalNodes) reverseCount++;
            }

            holjak += holjakCount;
            reverse += reverseCount;
        }

        return new int[]{holjak, reverse};
    }
}