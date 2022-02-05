import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int answer1 = 0, answer2 = 0, answer3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % 5]) {
                answer1++;
            }
            if(answers[i] == two[i % 8]) {
                answer2++;
            }
            if(answers[i] == three[i % 10]) {
                answer3++;
            }
        }
        
        int max = Math.max(Math.max(answer1, answer2), answer3);
        List<Integer> list = new ArrayList<>();
        if(max == answer1) list.add(1);
        if(max == answer2) list.add(2);
        if(max == answer3) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

/*
i 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers
o 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
c 시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
e

sol
1.
1번: 1,2,3,4,5
2번: 2,1,2,3,2,4,2,5
3번: 3,3,1,1,2,2,4,4,5,5

time O(n)
space O(1)
*/
