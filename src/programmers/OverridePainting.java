package programmers;

public class OverridePainting {
    static class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int index = 0;
            int[] wall = new int[n];
            //벽 상태 초기화
            for(int i = 0; i < section.length; i++) {
                wall[section[i] - 1] = -1;
            }
            //덧칠
            for(int i = 0; i < wall.length; i++) {
                if( wall[i] > -1 ) continue;
                if( wall[i] == -1 && wall.length - index > m) {
                    int temp = index;
                    for(int j = temp; j < temp + m; j++){
                        wall[j]++;
                    }
                    index += m;
                    answer++;
                } else {
                    answer++;
                    break;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(5, 4, new int[]{1,3});
        System.out.println("result = " + result);
    }
}
