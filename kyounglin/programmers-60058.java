package kyounglin;

class Solution {
    public String solution(String p) {
        return getRightString(p);
    }
    public String getRightString(String p){
        int parseIndex = getParseIndex(p);
        if(parseIndex < 0) return p;
        else {
            String u = p.substring(0, parseIndex);
            String v = p.substring(parseIndex);
            int uParseIndex = getParseIndex(u);
            if(uParseIndex < 0) return u + getRightString(v);
            return "(" + getRightString(v) + ")" + getReverseString(u.substring(1, u.length()-1));
        }
    }
    public String getReverseString(String p){
        StringBuilder sb = new StringBuilder();
        for(char c : p.toCharArray()){
            if(c == '(') sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }
    public int getParseIndex(String p){ // 올바른 괄호 문자열이면 -1을, 아니라면 u와 v를 분리하는 index를 return
        char[] charArr = p.toCharArray();
        boolean rightFlag = true;
        int stackSize = 0, openBracket = 0, closeBracket = 0, resultIndex = -1;
        for(int i = 0 ; i < charArr.length ; i++){
            if(charArr[i] == '('){
                stackSize++;
                openBracket++;
            } else {
                stackSize--;
                closeBracket++;
                if(stackSize < 0) rightFlag = false;
            }
            if(resultIndex < 0 && openBracket == closeBracket) resultIndex = i+1;
        }
        if(rightFlag) return -1;
        return resultIndex;
    }
}