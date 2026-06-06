package programmers;

public class Solution96053 {

    class Solution {
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long answer = -1;

            // 최소시간을 탐색
            long start =0, end = (long)1e15;
            int n = g.length;
            while(start <= end){

                long mid = (start + end)/2; // 탐색할 시간

                long T = mid;

                long sumCanMoveG = 0;
                long sumCanMoveS = 0;
                long sumCanMove = 0;// truck은 g+s를 합쳐서 w제한이 존재
                // 탐색할 시간을 사용할 때 최대 옮길 수 있는 최대양
                for(int i=0; i<n; i++){

                    long cnt = T / ( 2* t[i] ); // 왕복 가능한 횟수
                    if(T % (2*t[i]) >= t[i]){
                        cnt+=1; // 남은 시간이 1회당 차감 시간보다 클 때만 편도 1번 더 가능
                    }

                    long canMove = cnt * w[i]; // T에 옮길 수 있는 금이나 은의 양

                    sumCanMoveG += Math.min(g[i], canMove); // 제한된 양과 옮길 수 있는 양중 적은 것을 선택
                    sumCanMoveS += Math.min(s[i], canMove); // 제한된 양과 옮길 수 있는 양중 적은 것을 선택
                    sumCanMove += Math.min(s[i]+g[i], canMove);
                }

                if(sumCanMove >= (a+b) && sumCanMoveG >=a && sumCanMoveS >= b){
                    end = mid-1;
                    // 기록
                    answer = mid;
                }else{
                    start = mid+1;
                }


            }

            return answer;
        }
    }
}
