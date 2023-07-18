package programmers.level1;

public class Babbling {

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            // reaplseAll 정규식에 대해 기억해 둘것
            for(String target : babbling) {
                target = target.replaceAll("ayaaya|yeye|mama|woowoo", " ");
                target = target.replaceAll("aya|ye|ma|woo", "");
                if(target.equals("")) answer++;
            }

            return answer;
        }
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.solution(new String[]{"yayae","ayaye","woowoo", "uuu", "yeye", "yemawoo", "ayaayaa"});
        System.out.println("result = " + result);

    }
}
