package programmers.retry;
import java.util.*;
public class Solution42661 {



    class Solution {

        int[] parent;


        public void union(int a, int b){

            int aParent = findParent(a);
            int bParent = findParent(b);
            if(aParent!=bParent){
                parent[aParent] = bParent;
            }

        }

        public int findParent(int a){

            if(parent[a]== a){
                return a; // parent 자기자신
            }

            return parent[a] = findParent(parent[a]);
        }


        public int solution(int n, int[][] costs) {
            int answer = 0;
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }

            // 모든 섬의 cost의 최소 비용
            Arrays.sort(costs, (a, b) -> a[2] - b[2]);

            // 최소비용을 가지는 정점끼리 연결
            for(int[] node : costs){

                int a = node[0], b = node[1], c = node[2];

                if(findParent(a)!=findParent(b)){

                    union(a, b);
                    // 연결
                    answer += c;
                }
            }

            return answer;
        }
    }
}
