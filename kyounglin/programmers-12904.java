package kyounglin;

import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        for(int i = 1; i<s.length(); i++){
            int lt = i-1;
            int rt = i+1;
            int cnt = 1;
            while(lt>=0 && rt<s.length() && s.charAt(lt)==s.charAt(rt)){
                lt--;
                rt++;
                cnt+=2;
            }
            answer = Math.max(answer, cnt);
        }
        for(int i = 0; i<s.length()-1; i++){
            int cnt = 0;
            int lt = i;
            int rt = i+1;
            while(lt>=0 && rt<s.length() && s.charAt(lt)==s.charAt(rt)){
                lt--;
                rt++;
                cnt+=2;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}