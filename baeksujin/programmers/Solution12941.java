package programmers;
import java.util.*;
public class Solution12941 {


    class Solution
    {
        public int solution(int []A, int []B)
        {
            int answer = 0;

            // 첫번째 배열을 내림차순정렬, 두번째 배열을 오름차순정렬

            // Integer[] a2 = Arrays.stream(A).boxed().toArray(Integer[]::new);-> 시간초과
            Arrays.sort(A);
            Arrays.sort(B);

            // 정렬된 두개의 배열을 곱하여 sum

            int sum=0;
            for(int i=0; i<A.length; i++){
                int num = A[A.length-i-1] * B[i];
                sum += num;

            }

            return sum;
        }
    }
}
