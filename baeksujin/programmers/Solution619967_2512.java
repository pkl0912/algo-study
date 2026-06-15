package programmers;

import java.util.*;

public class Solution619967_2512 {

    class Solution {

        int[] parent;
        public int solution(int n, int[][] costs) {
            int answer = 0;

            // 최소 신장트리

            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }

            // 최소 cost간선우선 선택

            Arrays.sort(costs, (a,b) -> a[2] - b[2]);


            for(int [] node : costs){
                int a = node[0];
                int b = node[1];
                int cost = node[2];

                // 사이클이 존재하지 않는 가장 짧은 cost를 가지는 다음 간선을 잇는다
                if(findParent(a) != findParent(b)){
                    union(a,b);
                    answer += cost;
                }
            }


            return answer;
        }

        public void union(int a, int b){

            int pa = findParent(a);
            int pb = findParent(b);

            if(pa!=pb){
                parent[pb] = pa;
            }


        }

        public int findParent(int node){

            if(node != parent[node]){
                return findParent(parent[node]);
            }
            return node;

        }
    }
}
