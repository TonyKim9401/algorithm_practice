package programmers;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PrivacyExpiryDate {
    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer;

            String[] todaySplit = today.split("\\.");
            int todayDay = Integer.parseInt(todaySplit[2]);
            int todayMonth = Integer.parseInt(todaySplit[1]);
            int todayYear = Integer.parseInt(todaySplit[0]);
            LocalDate todayLD = LocalDate.of(todayYear, todayMonth, todayDay);
            String[] privacyDate;
            int cond;
            int index = 1;
            List<Integer> list = new ArrayList<>();


            Map<String, Integer> termMap = Arrays.stream(terms)
                                            .map(term -> term.split(" "))
                                            .collect(Collectors.toMap(
                                                    ts -> ts[0],
                                                    ts -> Integer.parseInt(ts[1])
                                            ));

            for (String privacy : privacies) {

                String[] spaceSplit = privacy.split(" ");
                privacyDate = spaceSplit[0].split("\\.");
                cond = termMap.get(spaceSplit[1]);

                boolean minusDate = false;
                boolean minusMonth = false;
                int priDate = Integer.parseInt(privacyDate[2]);
                int month = Integer.parseInt(privacyDate[1]) + cond;
                int priMonth = month % 12;
                int priYear = Integer.parseInt(privacyDate[0]) + (month / 12);
                if (priMonth == 0) {
                    priMonth = 12;
                    priYear = priYear - 1;
                }
                if (priDate - 1 == 0) {
                    priDate = 28;
                    minusDate = true;
                } else {
                    priDate--;
                }
                if (minusDate) {
                    if (priMonth - 1 == 0) {
                        priMonth = 12;
                        minusMonth = true;
                    } else {
                        priMonth--;
                    }
                }

                if(minusMonth) {
                    priYear = priYear - 1;
                }

                LocalDate pri = LocalDate.of(priYear, priMonth, priDate);
                if(pri.isBefore(todayLD)) list.add(index);

                index++;
            }
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.solution("2022.05.19"
                , new String[]{"A 6", "B 12", "C 3"}
                , new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

/*
        int[] result = solution.solution("2020.01.01"
                , new String[]{"Z 3", "D 5"}
                , new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});
*/

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
