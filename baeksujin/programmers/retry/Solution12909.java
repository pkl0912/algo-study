package programmers.retry;
import java.util.*;
public class Solution12909 {

    class Solution {
        boolean solution(String s) {
            boolean answer = true;


            Deque<Character> stack = new ArrayDeque<>();

            char[] target = s.toCharArray();
            for(char c : target){


                if(c == '('){
                    stack.push(c);
                }
                else{ // ')'
                    if(stack.size() == 0){
                        return false;
                    }
                    if(stack.peek() != '('){
                        return false;
                    }

                    stack.pop();
                }



            }

            if(stack.size() != 0){
                return false;
            }

            return true;
        }
    }
}
