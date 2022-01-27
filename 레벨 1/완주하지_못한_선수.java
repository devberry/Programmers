import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        
        for(String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(String p : participant) {
            if(map.containsKey(p)) {
                if(map.get(p) > 0) {
                    map.put(p, map.get(p) - 1);
                } else {
                    return p;
                }
            } else {
                return p;
            }
        }
        
        return "";
    }
}

/*
i 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion
o 완주하지 못한 선수의 이름을 return
c 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
e

sol
1.
completion을 돌면서 map에 이름과 count를 저장한다.
이후 participant를 돌면서 map에 해당 인덱스의 이름이 존재하는지 확인한다.
존재하면 value가 0보다 클 경우 value--, value가 이미 0일 경우 해당 이름을 return
존재하지 않으면 해당 이름을 return

time O(n) n == participant.length
space O(n)
*/
