package programmers;

public class CardBundle {

    static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {

            int c1idx = 0;
            int c2idx = 0;

            for(int i = 0; i < goal.length; i++) {

                String temp = goal[i];

                if (c1idx < cards1.length &&temp.equals(cards1[c1idx])){
                    c1idx++;
                    continue;
                }

                if (c2idx < cards2.length && temp.equals(cards2[c2idx])) {
                    c2idx++;
                } else {
                    return "No";
                }
            }
            return "Yes";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(
                new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"});
        System.out.println(solution1);
    }

}
