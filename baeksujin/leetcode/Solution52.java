package leetcode;

public class Solution52 {

    class Solution {

        int count = 0;
        int[] cols; // cols[row] = 그 행에 놓은 퀸의 열

        public void search(int n, int r){

            if(r == n){
                count+=1;
                return;
            }

            for(int c =0; c<n; c++){ // column temp

                boolean on = true;
                for(int i=0; i<r; i++){  // row temp
                    if( c == cols[i]){
                        on = false;
                    }
                    if(  Math.abs( r - i ) == Math.abs(c  - cols[i] ) ){
                        on = false;
                    }
                }

                if(on == true){
                    cols[r] = c;
                    search(n, r+1);
                }
            }
        }
        public int totalNQueens(int n) {

            cols = new int[n];
            search(n, 0);
            return count;

        }
    }
}
