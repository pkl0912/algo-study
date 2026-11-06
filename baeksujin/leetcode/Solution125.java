package leetcode;

public class Solution125 {

    class Solution {
        public boolean isPalindrome(String s) {

            /**
             1. 문제이해
             대문자 -> 소문자
             알파벳
             앞,뒤가 대칭을 만족

             s ++ , e -- (알파벳이 아닐 경우에는 ++ , -- 추가 작업. 동시에 대 -> 소)

             */


            int n = s.length();
            int l = 0, r = n-1; // l<r X stop
            boolean result = true;
            while(l<r){
                // 문자나 숫자만 남기고 제거
                if(!Character.isLetterOrDigit(s.charAt(l))){
                    l++;
                    continue;
                }
                if(!Character.isLetterOrDigit(s.charAt(r))){
                    r--;
                    continue;
                }

                // 대소문자 치환
                char left = Character.toLowerCase(s.charAt(l));
                char right = Character.toLowerCase(s.charAt(r));

                // equals
                if(left!=right) return false;

                // 포인터 이동 -> 다음 탐색
                l++;
                r--;
            }

            // l == r (size = 1)
            return result;

        }

    }
}
