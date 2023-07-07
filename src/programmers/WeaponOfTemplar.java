package programmers;

public class WeaponOfTemplar {
    static class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 1;

            int[] num = new int[number];

            for(int i = 0; i < num.length; i++) {
                num[i]++;
                if (i == 0) {
                    continue;
                }
                int temp = (i + 1) / 2;
                while(temp != 1) {
                    if((i + 1) % temp == 0) num[i]++;
                    temp--;
                }
                num[i]++;

                if (num[i] > limit) num[i] = power;
                answer += num[i];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(510, 3, 2);
        System.out.println("result = " + result);
    }
}
