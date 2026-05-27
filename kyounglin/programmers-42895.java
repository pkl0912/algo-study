package kyounglin;

import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if(N==number) return 1;
        Set<Integer>[] set = new HashSet[9];
        int num = 0;
        for(int i = 1; i<=8; i++){
            set[i] = new HashSet<>();
            num = num*10+N;
            set[i].add(num);
        }
        int answer = -1;
        for(int i = 2; i<=8; i++){
            for(int j = 1; j<i; j++){
                for(int a : set[j]){
                    for(int b : set[i-j]){
                        set[i].add(a+b);
                        set[i].add(a-b);
                        set[i].add(a*b);
                        if(a!=0) set[i].add(b/a);
                        if(b!=0) set[i].add(a/b);
                    }
                }
                if(set[i].contains(number)){
                    return i;
                }
            }
            
        }
        return -1;
    }
}
