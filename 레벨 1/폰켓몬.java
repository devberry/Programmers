import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        if(nums.length / 2 < set.size()) {
            answer = nums.length / 2;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}

/*
i N마리 폰켓몬의 종류 번호가 담긴 배열 nums
o N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 
그때의 폰켓몬 종류 번호의 개수
c nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
e 

sol
1.
nums의 길이를 구한다.
nums를 돌면서 선택하는 폰켓몬의 종류 번호를 set에 넣는다.
set.size보다 nums.length/2가 작다면 nums.length/2 return
그렇지 않으면 set.size를 return

time O(n)
space O(n)
*/
