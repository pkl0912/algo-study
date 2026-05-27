package programmers;
import java.util.*;
public class Solution42861 {

    /**
     * 간선-간선 최소가 아니라, 네트워크 전체의 최소는 사이클이 있으면 안 되면서 짧은 간선끼리 연결해주면 됨
     * 최소 간선부터 이어주고 다음꺼랑 사이클 체크필요 - 그리디
     */

    class Solution {

        static int[] parent;

        public int solution(int n, int[][] costs) {

            // 최소신장트리


            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }

            // 간선의 비용이 작은 것부터 선택
            Arrays.sort(costs, (a, b) -> a[2] - b[2]);

            int answer = 0;

            for(int[] edge : costs){
                int a = edge[0];
                int b = edge[1];
                int cost = edge[2];

                // 사이클체크
                if(find(a) != find(b)){
                    union(a, b);
                    answer += cost;
                }
            }

            return answer;
        }

        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa != pb){
                parent[pa] = pb; // 연결
            }
        }
    }
}
