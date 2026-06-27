import java.util.*;

class Solution {
    long[] prefix;       
    long[] blockSum;     
    int n;

    public long[] solution(int[] arr, long l, long r) {
        n = arr.length;
        prefix = new long[n + 1];
        blockSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
            blockSum[i + 1] = blockSum[i] + (long) arr[i] * arr[i]; 
        }

        long total = prefix[n];
        long K = rangeSum(arr, l, r);
        long len = r - l + 1;
        long C = countSubarrays(arr, total, len, K);
        return new long[]{K, C};
    }

    private long rangeSum(int[] arr, long a, long b) {
        int bi = blockOf(a);
        int bj = blockOf(b);
        if (bi == bj) {
            return (b - a + 1) * (long) arr[bi];
        }
        long sum = 0;
        sum += (prefix[bi + 1] - (a - 1)) * (long) arr[bi];   
        sum += blockSum[bj] - blockSum[bi + 1];               
        sum += (b - prefix[bj]) * (long) arr[bj];             
        return sum;
    }

    private int blockOf(long pos) {
        int lo = 0, hi = n - 1, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (prefix[mid + 1] >= pos) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return ans;
    }

    private long countSubarrays(int[] arr, long total, long len, long K) {
        long count = 0;
        long maxStart = total - len + 1;   
        if (maxStart < 1) return 0;

        long s = 1;
        while (s <= maxStart) {
            long e = s + len - 1;
            int sb = blockOf(s);
            int eb = blockOf(e);

            long sBlockEnd = prefix[sb + 1];
            long eBlockEnd = prefix[eb + 1];
            long sLimitFromE = eBlockEnd - len + 1;            
            long segEnd = Math.min(maxStart, Math.min(sBlockEnd, sLimitFromE));

            long f1 = rangeSum(arr, s, e);
            long d = (long) arr[eb] - arr[sb];                 
            long cnt = segEnd - s + 1;

            if (d == 0) {
                if (f1 == K) count += cnt;
            } else {
                long diff = K - f1;
                if (diff % d == 0) {
                    long t = diff / d;                        
                    if (t >= 0 && t <= cnt - 1) count += 1;
                }
            }
            s = segEnd + 1;
        }
        return count;
    }
}