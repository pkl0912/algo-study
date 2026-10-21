package programmers;

public class Solution62 {

    class Solution {
        public int uniquePaths(int m, int n) {

            // 현위치로 오기 위해서 몇가지 가능한지 체크

            int[][] map = new int[m][n];

            map[0][0] = 1;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){

                    if(i==0 && j==0){
                        continue;
                    }

                    int t = 0;
                    int l = 0;
                    if( i-1 >=0 ){
                        t = map[i-1][j];
                    }
                    if( j-1 >=0 ) {
                        l = map[i][j-1] ;
                    }
                    map[i][j] = t+l;

                }
            }

            return map[m-1][n-1];
        }
    }
}
