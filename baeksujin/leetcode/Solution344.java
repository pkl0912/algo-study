package leetcode;

public class Solution344 {

    class Solution {

        public void swap(char[] s, int i, int j){

            char temp;

            temp = s[i];
            s[i] = s[j]; // a => b
            s[j] = temp; // b = temp => a

        }

        public void reverseString(char[] s) {

            // 1. init
            int n = s.length;
            // char[] output = new char[n];
            // System.out.println(output);

            // // 2. for문을 역방향으로 스캔
            // for(int i=n-1; i>=0; i--){
            //     int j = n - i - 1;
            //     output[j] = s[i];
            // }

            // // 3. output -> s 에 저장
            // for(int i=0; i<n; i++){
            //     s[i] = output[i];
            // }

            /**
             메모리 사용량 개선 포인트 : O(1)의 메모리를 활용해야함.
             */


            // 마지막꺼를 꺼내놓고 잠시 temp에 저장. 앞뒤변경

            // 5/2 -> 2 (1)  4 / 2 -> 2 (1)
            for(int i=0; i<= n/2-1; i++){
                swap(s, i, n-i-1);
            }


            // 시간복잡도 : n
            // 공간복잡도 : 1

        }
    }
}
