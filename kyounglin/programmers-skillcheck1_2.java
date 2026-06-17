package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        Stack<Integer> stack = new Stack();
        for(int move: moves){
            int col = move-1;
            for(int i = 0; i<n; i++){
                if(board[i][col]!=0){
                    int temp = board[i][col];
                    board[i][col]=0;
                    if(!stack.isEmpty() && stack.peek()==temp){
                        stack.pop();
                        answer+=2;
                    }else{
                        stack.push(temp);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}