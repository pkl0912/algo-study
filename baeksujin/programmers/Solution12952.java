package programmers;

public class Solution12952 {

        int count = 0;
        int nSize =0;
        int[] queenIndex; // 각 행에 담을 퀸 위치를 저장

        public void backTracking(int i){

            if(i == nSize){
                count+=1;
                return ;
            }

            for(int j=0; j<nSize; j++){
                queenIndex[i] = j;// i행에 퀸은 j에 위치함
                // j행에 퀸을 위치시킬 수 있다면 다음 행으로 이동
                boolean isValid = true;
                for(int k=0; k<i; k++){// 이전 행에서 둔 퀸의 위치에 따라서 현재 퀸이 가능한지 여부가 달라짐
                    if(queenIndex[k] == queenIndex[i]){//같은 열 안됨
                        isValid = false;
                        break;
                    }
                    if(Math.abs(queenIndex[k]-queenIndex[i]) == Math.abs(k-i)){ // row와 column의 차이가 동일한지 체크
                        isValid = false;
                        break;
                    }
                }

                if(isValid){
                    backTracking(i+1);
                }


            }


        }
        public int solution(int n) {
            int answer = 0;

            nSize = n;
            queenIndex = new int[n];

            // 가로, 세로, 대각선으로 이동하기 때문에 같은 줄과 대각선에 있으면 안 됨

            // 같은 열에 있으면 안 됨.

            // 탐색은 1줄씩 +1을 하면서 탐색.-> 기본
            // 탐색시, 같은 열에있는지 대각선에 있는지 이전 퀸의 위치를 확인필요
            backTracking(0);


            return count;
        }
}
