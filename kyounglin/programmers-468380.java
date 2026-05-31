package kyounglin;

import java.util.*;

class Solution {
    public long solution(int[] arr, long l, long r) {
        int n = arr.length;
        long[] pre   = new long[n + 1];   
        long[] sqPre = new long[n + 1];  
        for (int i = 0; i < n; i++) {
            pre[i + 1]   = pre[i]   + arr[i];
            sqPre[i + 1] = sqPre[i] + (long) arr[i] * arr[i];
        }

        return f(arr, pre, sqPre, r - 1) - f(arr, pre, sqPre, l - 2);
    }


    private long f(int[] arr, long[] pre, long[] sqPre, long p) {
        if (p < 0) return 0;

        int lo = 0, hi = arr.length - 1, b = hi;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (pre[mid + 1] - 1 >= p) { b = mid; hi = mid - 1; }
            else                         lo = mid + 1;
        }
        long countInBlock = p - pre[b] + 1;     
        return sqPre[b] + countInBlock * arr[b]; 
    }
}