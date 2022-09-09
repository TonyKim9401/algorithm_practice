import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class YearOf2016 {
    public static class Solution {
        public String solution(int a, int b) {
            String answer = "";

            LocalDate date = LocalDate.of(2016, a, b);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            int dayOfWeekNumber = dayOfWeek.getValue();

            //SUN,MON,TUE,WED,THU,FRI,SAT
            switch (dayOfWeekNumber){
                case 1 : answer = "MON";
                        break;
                case 2 : answer = "TUE";
                    break;
                case 3 : answer = "WED";
                    break;
                case 4 : answer = "THU";
                    break;
                case 5 : answer = "FRI";
                    break;
                case 6 : answer = "SAT";
                    break;
                case 7 : answer = "SUN";
                    break;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(5, 24);
        System.out.println(solution1);
    }
}
