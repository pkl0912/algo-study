package programmers;

public class Solution60057 {
    class Solution {
        public int solution(String s) {
            int answer = s.length();

            // 1~ len/2까지를 돌면서 압축을 진행하고 가장 짧은 것을 기록 -> for문이 끝난 결과를 출력

            for(int i=1; i<=s.length()/2; i++){

                //System.out.println("compact size : " + i);

                StringBuffer sb = new StringBuffer();
                int j=0;
                int count = 1; // i개씩 이어진 문자 - 몇번반복하는지를 저장

                String current = s.substring(0, i);

                while(j+i < s.length()){

                    String next;

                    if (j + 2*i > s.length()) {
                        next = s.substring(j+i);   // 남은 거 전부
                    } else {
                        next = s.substring(j+i, j + 2*i);
                    }
                    if(current.equals(next)){
                        count+=1;
                    }else{ // i개의 연속된 부분문자열을 만족하지 않으면 그냥 넘김
                        if(count!=1){
                            sb.append(count);
                        }
                        sb.append(current);
                        count=1;


                    }
                    current=next;
                    j = j+i;

                }

                if(count!=1){
                    sb.append(String.valueOf(count));
                }
                sb.append(current);

                int len = sb.toString().length();
                // System.out.println("compact string : " + sb.toString());
                // System.out.println("compact string : " + sb.toString().length());
                answer = answer > len ? len : answer;

            }

            return answer;
        }
    }

}
