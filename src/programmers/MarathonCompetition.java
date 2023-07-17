package programmers;

import java.util.HashMap;
import java.util.Map;

public class MarathonCompetition {
    static class Solution {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> playerMap = new HashMap<>();
            for(int i = 0; i < players.length; i++) {
                playerMap.put(players[i], i);
            }

            String temp;
            String called;
            int idx;
            int idxTemp;

            for (int i = 0; i < callings.length; i++) {
                called = callings[i]; // 불린놈
                idx = playerMap.get(callings[i]); // 불린놈 등수
                temp = players[idx - 1]; // 앞에놈
                idxTemp = playerMap.get(temp); // 앞에놈 등수

                playerMap.put(called, idxTemp);
                playerMap.put(temp, idx);

                players[idxTemp] = called;
                players[idx] = temp;
            }

            return players;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = solution.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        for (String s : result) {
            System.out.print(s + " ");
        }

    }
}
