package programmers;
import java.util.*;

public class Solution86971 {


    class Solution {


        boolean[] visited;

        public int bfs(int currentNode, List<List<Integer>> wires){


            Queue<Integer> queue = new ArrayDeque<>(); // 발견했지만 아직 사용하지 않은 것들을 넣음. 최악의 경우 N-1공간복잡도 O(N)
            queue.add(currentNode);

            int nodeCount = 1;
            visited[currentNode] = true;

            while(!queue.isEmpty()){ // 최대 n번 돌 수 있음( 노드를 1번만 사용가능 ) -> O(N)

                // get
                int current = queue.poll();

                for(int next: wires.get(current)){

                    if(!visited[next]){
                        queue.offer(next);
                        visited[next] = true; // 딱 한번만 사용이 가능. (탐색시점부터!!)
                        nodeCount += 1;
                    }
                }


            }



            return nodeCount;
        }


        public int solution(int n, int[][] wires) {
            int answer = n; // 초기값

            /**
             트리 ( 사이클 X )
             2개의 네트워크로 분할 -> 두개의 개수가 최대한 비슷해야함.
             */

            // 초기화
            visited = new boolean[n+1]; // false init
            List<List<Integer>> linked = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                linked.add(new ArrayList<>());
            }

            for(int[] w: wires){
                int w1 = w[0];
                int w2 = w[1];
                linked.get(w1).add(w2);
                linked.get(w2).add(w1);
            }
            // 디버깅 >>
            for(int i=0; i<n+1; i++){
                System.out.println(linked.get(i));
            }




            // wire를 탐색하면서, 끊어보며 각각의 자식 노드의 개수를 sum (다만, 1쪽만 구하면 다른쪽은 알 수 있음)
            // 자식노드들의 개수를 구하는 방법 : bfs를 활용하여 전체 탐색을 진행
            // bfs(currentNode, wires) : currentNode 시작. 연결리스트를 찾아가며 더이상 깊이가 깊어질 수 없을 때까지++를 진행
            int min = n;
            for(int[] w : wires){
                int current = w[0], next = w[1];

                // next -> 가지못하도록 visited
                visited = new boolean[n+1]; // 새 배열을 대입하는 순간 이전 배열은 참조가 끊기기에 GC 대상이 된다.
                visited[next] = true;
                int linkedCurrentNum = bfs(current, linked); // 탐색
                int linkedOtherNum = n - linkedCurrentNum;

                int diffCount = Math.abs(linkedCurrentNum - linkedOtherNum);

                min = (min > diffCount ) ? diffCount : min;
            }



            return min;
        }

        /**
         * 시간복잡도 : O(N^2). bfs 1회 : O(N) -> N번 반복
         * 공간복잡도 : 각 노드가 1개씩의 리스트를 가짐. n이 아니라 길이는 차수. -> 동시에 살아있는 최대량 !! ( 이전은 고려 X)
         */

    }
}
