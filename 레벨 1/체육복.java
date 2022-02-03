import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] res = new int[n + 1];
        
        for(int i : lost) {
            res[i] = -1;
        }
        
        for(int i : reserve) {
            if(res[i] == 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        
        for(int i = 1; i < res.length; i++) {
            if(res[i] == -1) {
                if(i - 1 != 0 && res[i - 1] == 1) {
                    res[i - 1] = 0;
                    res[i] = 0;
                    continue;
                }
                if(i + 1 != res.length && res[i + 1] == 1) {
                    res[i + 1] = 0;
                    res[i] = 0;
                    continue;
                }
            }
        }
        
        int cnt = 0;
        
        for(int i : res) {
            if(i == -1) {
                cnt++;
            }
        }
        
        return n - cnt;
    }
}

/*
i 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
o 체육수업을 들을 수 있는 학생의 최댓값
c 전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
e

sol
1.
크기 n+1인 배열 res를 만든다.
값이 0이면 체육복이 있는 상태, -1이면 없는 상태, 1이면 여벌 체육복이 있는 상태

lost의 원소를 읽으면서 res의 해당 인덱스에 -1을 넣는다.
reserve의 원소를 읽으면서 res의 기존 값이 0이면 1, -1이면 0을 넣어준다.
res의 원소를 읽으면서 res의 값이 -1이면 앞과 뒤의 인덱스에 1이 있는지 확인한다.
있으면 빌려준 인덱스의 값을 0으로 바꿔주고 빌린 인덱스의 값도 0으로 바꾼다.
다음 원소로 넘어간다.
과정이 다 끝난 뒤 다시 한 번 res를 돌면서 -1인 값의 cnt를 구하고 n - cnt를 return

time O(4n == n)
space O(n)
*/
