package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {

    class Solution {

        int[] queensColumn;
        List<List<String>> result = new ArrayList<>();

        public void search(int n, int level){

            if(n == level){
                List<String> current = new ArrayList<>();
                for(int i=0; i<n; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j=0; j<n; j++){
                        if(queensColumn[i] == j){
                            sb.append("Q");
                        }else{
                            sb.append(".");
                        }

                    }
                    String line = sb.toString();
                    current.add(line);
                }
                result.add(current);
                return;

            }


            for(int c= 0; c<n; c++){
                boolean on = true;

                for(int r = 0; r<level; r++){


                    if(c==queensColumn[r]){
                        on = false;
                    }
                    if(Math.abs(level - r) == Math.abs( c - queensColumn[r] ) ){
                        on = false;
                    }


                }


                if(on){
                    queensColumn[level] = c;
                    search(n, level+1);
                }


            }


        }

        public List<List<String>> solveNQueens(int n) {

            /**
             2차원 배열. 1개씩 배정하가면서 밑으로 내려가야함.
             */
            queensColumn = new int[n];
            search(n, 0);

            return result;

        }
    }
}
