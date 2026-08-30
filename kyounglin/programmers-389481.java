import java.util.*;

class Solution {

    public String solution(long n, String[] bans) {

        long[] banNumbers = new long[bans.length];

        for (int i = 0; i < bans.length; i++) {
            banNumbers[i] = toNumber(bans[i]);
        }

        Arrays.sort(banNumbers);

        long target = n;

        for (long banNumber : banNumbers) {
            if (banNumber <= target) {
                target++;
            } else {
                break;
            }
        }

        return toWord(target);
    }

    private long toNumber(String word) {
        long num = 0;

        for (char c : word.toCharArray()) {
            num = num * 26 + (c - 'a' + 1);
        }

        return num;
    }


    private String toWord(long num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            num--;

            sb.append((char) ('a' + num % 26));
            num /= 26;
        }

        return sb.reverse().toString();
    }
}