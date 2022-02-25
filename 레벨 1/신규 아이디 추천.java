import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        answer = new_id.toLowerCase();
        //2단계
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i);
            
            if(Character.isLowerCase(ch) || Character.isDigit(ch) ||
               ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            } else {
                continue;
            }
        }
        //3단계
        answer = sb.toString();
        while(answer.indexOf("..") != -1) {
            answer = answer.replace("..",".");
        }
        //4단계
        if(answer.charAt(0) == '.') {
            answer = answer.substring(1);
        } else if(answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        //5단계
        if(answer.equals("")) {
            answer = "a";
        }
        //6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if(answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        //7단계
        if(answer.length() <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        
        return answer;
    }
}
