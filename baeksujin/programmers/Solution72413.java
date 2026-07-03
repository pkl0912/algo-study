package programmers;
import java.util.*;

public class Solution72413 {


    class Solution {

        int[][] map;
        int N;
        int INF = 20000000;


        private void floyd(){


            for(int k=1;k <= N; k++){
                for(int i=0; i<=N; i++){
                    for(int j=0; j<=N; j++){
                        if(map[i][k] == INF || map[k][j] == INF){
                            continue;
                        }
                        if(map[i][j] > map[i][k] + map[k][j]){
                            // k를 거쳐서 가는게 빠르면 최단거리를 update
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }


        }
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = INF;
            N = n;
            // 간선에 비용이 있음. 최소 비용을 사용하며 이동할 수 있어야하기에 다익스트라를 사용해야하는 것으로 보임
            // a,b를 합친 금액이 최소 비용을 유지해야함
            // 합승 : s -> 합승 지점(t) + (t -> A집) + (t -> B)집. 합승지점에따라서 달라짐. // 합승을 사용하지 않않는 경우도 고려필요


            // s -> 각 노드까지 가는데 최단거리
            map = new int[n+1][n+1];

            for(int i=1; i<=n; i++){
                Arrays.fill(map[i],INF );
                map[i][i] = 0;
            }
            for(int[] f : fares){
                map[f[0]][f[1]] = f[2];// cost insert
                map[f[1]][f[0]] = f[2];// cost insert
            }

            floyd();

            // 합승노드 scan
            for(int i = 1; i<=n; i++){

                // start -> pass
                // if(i == s ){
                //     continue;
                // } // 합승하지 않고 각자 가는 것이 최적일수있음.(예외잡힘)


                // i지점 -> temp (합승지점까지의 최단거리를 구해야함) / + (각자의 집 까지의 거리)
                answer = Math.min(answer, map[s][i]+ map[i][a] + map[i][b]);
            }



            return answer;
        }
    }
}
