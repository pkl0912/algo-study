import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int n = a.length;

        long sum = 0;
        long[] weight = new long[n];

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            weight[i] = a[i];
            sum += a[i];
            adj[i] = new ArrayList<>();
        }

        if (sum != 0) return -1;

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] order = new int[n];
        int[] stack = new int[n];

        Arrays.fill(parent, -1);

        int top = 0;
        int count = 0;

        stack[top++] = 0;
        visited[0] = true;

        while (top > 0) {
            int node = stack[--top];
            order[count++] = node;

            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    stack[top++] = next;
                }
            }
        }

        long answer = 0;

        for (int i = count - 1; i > 0; i--) {
            int node = order[i];

            answer += Math.abs(weight[node]);
            weight[parent[node]] += weight[node];
        }

        return answer;
    }
}