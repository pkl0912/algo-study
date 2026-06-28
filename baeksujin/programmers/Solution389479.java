package programmers;

public class Solution389479 {

    class Solution {

        // 시간대멸 서버 수
        int[] server = new int[24];

        public int solution(int[] players, int m, int k) {
            int count = 0;
            // 필요서버 : players / server

            for(int i=0; i<24; i++){
                int num = players[i];
                int currentS = server[i];
                int needS = num  / m;
                int addServer = needS - currentS;

                if(addServer > 0){
                    count+=addServer;
                    // 시간증가
                    for(int j=0; j<k; j++){
                        if(i+j>=24){
                            break;// 범위밖
                        }
                        server[i+j] += addServer;
                    }
                }


            }

            return count;
        }
    }

}
