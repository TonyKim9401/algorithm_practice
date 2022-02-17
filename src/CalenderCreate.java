import java.util.Calendar;
import java.util.Scanner;

public class CalenderCreate {
    public static void main(String[] args) {
        int year, month, date, i;
        Calendar calendar = Calendar.getInstance();

        int startDay;
        int lastDay;
        int inputDate = 1; // 입력 날짜

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("연도를 입력하세요 : ");
            year = scanner.nextInt();
            System.out.print("월을 입력하세요(1~12월) : ");
            month = scanner.nextInt();

            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1); // month는 1을 빼줘야함
            calendar.set(Calendar.DATE, 1);
            startDay = calendar.get(Calendar.DAY_OF_WEEK); // 월 시작 요일
            lastDay = calendar.getActualMaximum(Calendar.DATE); // 월 마지막 날짜

            System.out.println();
            System.out.println("" + year + "년 " + month + "월 달력입니다.");
            System.out.println("---------------------------");
            System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
            System.out.println("---------------------------");
            int weekday = startDay - 1 % 7;
            for (i = 0; i < weekday; i++) {
                System.out.print("\t" + "");
            }

            int firstLine = 7 - weekday;
            for (int day = 1; day <= firstLine; day++) {
                System.out.printf("%d\t", day);
            }

            for (int j = firstLine + 1; j <= lastDay; j++) {
                if (j % 7 == firstLine + 1) {
                    System.out.println();
                }
                System.out.printf("%d\t", j); // 요일이 토요일이면 다음칸으로 옮겨야 하니까


            }

            System.out.println("\n---------------------------\n");
            System.exit(0);
        }
    }
}
