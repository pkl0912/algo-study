package programmers.retry;

public class Solution468372 {

    class Solution {

        int answer;

        public int solution(int dist_limit, int split_limit) {
            answer = 1; // root node


            dfs(
                    1,
                    0,
                    1,
                    1,
                    dist_limit,
                    split_limit
            );

            return answer;
        }


        void dfs(
                int currentLeaf,
                int currentUsedSplitNode,
                long currentSplitDegree,
                int currentCanSplitNode,
                int dist_limit,
                int split_limit
        ) {

            // 현재 상태에서 더 이상 분배하지 않는 경우
            answer = Math.max(answer, currentLeaf);// dfs의 모든 결과중 max find


            // 현재 분배 가능한 노드가 없음
            if (currentCanSplitNode == 0) {
                return;
            }


            // 앞으로 분배 가능한 횟수
            int remainSplitNode =
                    dist_limit - currentUsedSplitNode;


            if (remainSplitNode <= 0) {
                return;
            }


            /*
             * 현재 분배 가능한 노드 중
             * 몇 개를 분배할지 선택
             */
            // for (int selectNode = 1;
            //      selectNode <= Math.min(currentCanSplitNode, remainSplitNode);
            //      selectNode++) {//시간초과
            int selectNode = Math.min(currentCanSplitNode, remainSplitNode);
            // 남은 개수중 최대한 많이 분배


            /*
             * 선택한 노드를 2개 또는 3개로 분배
             */
            for (int child = 2; child <= 3; child++) {


                long nextSplitDegree =
                        currentSplitDegree * child;


                // 분배도 제한 초과
                if (nextSplitDegree > split_limit) {
                    continue;
                }

                int nextLeaf =
                        currentLeaf + selectNode * (child - 1);

                int nextCanSplitNode = selectNode * child;


                dfs(
                        nextLeaf,
                        currentUsedSplitNode + selectNode,
                        nextSplitDegree,
                        nextCanSplitNode,
                        dist_limit,
                        split_limit
                );
            }
            //}엥
        }
    }
}
