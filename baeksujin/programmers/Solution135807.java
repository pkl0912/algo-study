package programmers;

import java.util.*;

public class Solution135807 {

    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;

            int gcdA = arrayA[0], gcdB = arrayB[0];

            for(int i = 1; i < arrayA.length; i++){
                gcdA = gcd(gcdA, arrayA[i]);
                gcdB = gcd(gcdB, arrayB[i]);
            }

            boolean flagA = true, flagB = true;

            if(gcdA == 1) flagA = false;
            if(gcdB == 1) flagB = false;

            int n = arrayA.length;

            // gcdB가 A를 나누는지 체크
            if(gcdB != 1){
                for(int i = 0; i < n; i++){
                    if(arrayA[i] % gcdB == 0){
                        flagB = false;
                        break;
                    }
                }
            }

            // gcdA가 B를 나누는지 체크
            if(gcdA != 1){
                for(int i = 0; i < n; i++){
                    if(arrayB[i] % gcdA == 0){
                        flagA = false;
                        break;
                    }
                }
            }

            // 둘 다 가능하면 max
            if(flagA) answer = Math.max(answer, gcdA);
            if(flagB) answer = Math.max(answer, gcdB);

            return answer;
        }

        public int gcd(int a, int b){
            while(b != 0){
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
    }
}
