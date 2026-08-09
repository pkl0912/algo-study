package kyounglin;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int multiple = brown+yellow;
        int plus = (brown+4)/2;
        int a = 0;
        int b = 0;
        for(int i = 1; i<=plus/2; i++){
            b = i;
            a = plus - i;
            if(a*b==multiple && (a-2)*(b-2)==yellow){
                answer = new int[]{a,b};
                break;
            }
        }
        return answer;
    }
}