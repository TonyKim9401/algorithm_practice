package programmers;

import java.util.*;

public class GetReportResult {
    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            Map<String, HashSet<String>> userMap = new HashMap<>();
            Map<String, Integer> reportMap = new HashMap<>();

            for (int i = 0; i < id_list.length; i++) {
                userMap.put(id_list[i], new HashSet<String>());
                reportMap.put(id_list[i], 0);
            }

            for (int i = 0; i < report.length; i++) {
                String[] split = report[i].split(" ");
                String userId = split[0];
                String reportedId = split[1];

                HashSet<String> set = userMap.get(userId);
                int count = reportMap.get(reportedId);
                count += 1;

                if (set.contains(reportedId)) count -= 1;

                set.add(reportedId);
                userMap.put(userId, set);
                reportMap.put(reportedId, count);
            }

            for(int i = 0; i < id_list.length; i++) {
                int reportedCount = reportMap.get(id_list[i]);
                if (reportedCount >= k) {
                    for (int j = 0; j < userMap.size(); j++) {
                        HashSet<String> set = userMap.get(id_list[j]);
                        if (set.contains(id_list[i])) {
                            answer[j]++;
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
                ,2);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
