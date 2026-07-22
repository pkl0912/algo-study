package programmers.retry;

public class Solution768377 {

    class Solution {
        public int solution(int[][] cost, int[][] hint) {
            int answer = 0;

            // 2^16승. 의 조합
            int n = hint.length;
            int minValue = Integer.MAX_VALUE;

            // 비트마스크 (힌트스테이지에서 힌트사용에 대한 여부 o,x)의 조합을 구한다.
            for(int m=0; m < ( 1 << n  ); m++){

                int[] hintCountByS = new int[n+1]; // 힌트를 사용하여 얻은 힌트권수
                int sumCost = 0;

                for(int i=0; i< n+1; i++){//stage 탐색
                    // 최솟값
                    int minCost = cost[i][0];

                    for(int j=1; j< n+1; j++){
                        if(hintCountByS[i] >= j){
                            minCost = Math.min(cost[i][j], minCost);//가능한 힌트를 사용한 경우중 최솟값
                        }
                    }

                    sumCost += minCost;

                    // 힌트사용
                    if ((m & (1 << i)) != 0) {

                        sumCost += hint[i][0];

                        for (int j = 1; j < hint[i].length; j++) {
                            hintCountByS[hint[i][j] - 1]++;
                        }
                    }

                }


                minValue = Math.min(minValue, sumCost);


            }



            return minValue;
        }
    }
}
