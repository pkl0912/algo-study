package programmers;
import java.util.*;
public class Solution340211 {



    class Solution {
        public int solution(int[][] points, int[][] routes) {
            int answer = 0;
            int maxTime = 20001;// 200*100
            // 최단거리를 갈 수 있는 모든 경우의 수 저장. 겹치면 +1
            List<int[]>[] visitedTime = new List[maxTime + 1];
            for (int i = 0; i <= maxTime; i++) {
                visitedTime[i] = new ArrayList<>();
            }

            int robotCount = routes.length;

            for (int robotIdx = 0; robotIdx < robotCount; robotIdx++) {
                int[] route = routes[robotIdx];
                int time = 0;

                // 시작점 기록 (0초)
                int[] start = points[route[0] - 1];
                int curR = start[0], curC = start[1];
                visitedTime[time].add(new int[]{curR, curC});

                for (int j = 1; j < route.length; j++) {
                    int[] target = points[route[j] - 1];
                    int targetR = target[0], targetC = target[1];

                    // r 먼저 맞추기
                    while (curR != targetR) {
                        curR += (targetR > curR) ? 1 : -1;
                        time++;
                        visitedTime[time].add(new int[]{curR, curC});
                    }
                    // 그다음 c 맞추기
                    while (curC != targetC) {
                        curC += (targetC > curC) ? 1 : -1;
                        time++;
                        visitedTime[time].add(new int[]{curR, curC});
                    }
                }
            }

            // visitedTime을 전부 set으로 변환후 count+
            for(List<int[]> visited: visitedTime){
                if(visited.isEmpty()) continue;


                // int[]를 map으로 전환
                Map<Integer, Integer> countByPoints = new HashMap<>();
                for(int[] p: visited ){

                    int x = p[0], y = p[1];
                    int xAndY = x*1000 + y;
                    countByPoints.put(xAndY, countByPoints.getOrDefault(xAndY, 0) + 1);
                }

                for(int count: countByPoints.values()){
                    if(count >=2){
                        answer++;// 위험한 상황 -> time에 존재
                    }
                }

            }



            return answer;
        }
    }
}
