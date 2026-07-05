package programmers;

public class Solution468371 {

    class Solution {


        public int getLcm(int a, int b){
            return (a*b) / gcd(a,b);
        }
        public int gcd(int a, int b){
            while(b != 0){
                int t = a % b;
                a = b;
                b = t;
            }

            return a;
        }
        public int solution(int[][] signals) {
            int answer = -1;


            int n = signals.length;
            int[] yStart = new int[n];
            int[] period = new int[n];

            for(int i=0; i<n; i++){
                yStart[i] = signals[i][0]+1;// 시작점
                period[i] = signals[i][0] + signals[i][1] + signals[i][2]; // 주기
            }

            int lcm = period[0];
            for(int i=1; i<n; i++){
                lcm = getLcm(lcm, period[i]);
            }

            // 2차원 배열생성
            int[][] yTime = new int[n][lcm+1];

            int indx = 0;

            while(indx < n){
                for(int i=0; i<=lcm; i= i+period[indx]){

                    for(int j=i+yStart[indx]; j<i+yStart[indx]+signals[indx][1]; j++){
                        if(j<=lcm) yTime[indx][j] =1;
                    }


                }
                indx +=1;
            }



            for(int i=1; i<lcm; i++){// time
                int count = 0;
                for(int j=0; j<n; j++){ // 신호등
                    if( yTime[j][i] == 1){
                        count+=1;
                    }
                }
                if(count == n){
                    answer = i;
                    return answer;
                }
            }

            return answer;
        }

    }
}
