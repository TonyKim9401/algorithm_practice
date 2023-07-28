package ndb.greedy;

import java.util.*;

public class Practice {

    static void adventureGuild(int N, int[] players) {

        Arrays.sort(players);
        int count = 0;
        int answer = 0;

        for (int i = 0; i < players.length; i++) {
            count += 1;
            if (count >= players[i]) {
                answer += 1;
                count = 0;
            }
        }

        System.out.println("Practice.adventureGuild = " + answer);

    }

    static void multiplePlus(String str) {

        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            if (answer == 0 || str.charAt(i) == '0' || str.charAt(i) == '1') {
                answer += str.charAt(i) - '0';
            } else {
                answer *= str.charAt(i) - '0';
            }
        }
        System.out.println("Practice.multiplePlus = " + answer);

    }

    static void filpString(String str) {

        int one = 0;
        int zero = 0;

        if (str.charAt(0) == '1') {
            zero += 1;
        } else {
            one += 1;
        }

        for (int i = 0; i < str.length() -1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') zero += 1;
                else one += 1;
            }
        }

        System.out.println("Practice.filpString = " + Math.min(zero, one));
    }

    static void impossiblePrice (int N, int[] prices) {

        Arrays.sort(prices);

        int min = 1;

        // 1, 1, 2, 3, 9
        for (int i = 0; i < prices.length; i++) {
            if (min < prices[i]) {
                System.out.println("Practice.impossiblePrice = " + min);
            }
            min += prices[i];
        }
    }

    static void selectBalls (int N, int M, int[] balls) {

        int[] ballCount = new int[11];

        for (int i = 0; i < balls.length; i++) {
            ballCount[balls[i]] += 1;
        }

        // [0,1,2,2]
        int answer = 0;
        for (int i = 0; i < ballCount.length; i++) {
            N -= ballCount[i];
            answer += N * ballCount[i];
        }
        System.out.println("Practice.selectBalls = " + answer);
    }

    static void muziLive(int[] food_times, int k) {

        class Food {
            int time;
            int idx;
            Food(int t, int i){
                time = t;
                idx = i;
            }
        }

        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(food_times[i], i+1));
        }

        foods.sort((o1, o2) -> {
            return o1.time - o2.time;
        });

        int preTime = 0;
        int eaters = foods.size();
        boolean check = false;
        for (int i = 0; i < foods.size(); i++) {

            // 양수 혹은 0만 나옴
            long diff = foods.get(i).time - preTime;

            if (diff != 0) {
                long eat = diff * eaters;
                if (eat <= k) {
                    k -= eat;
                    preTime = foods.get(i).time;
                } else {
                    k %= eaters;
                    foods.subList(i, foods.size())
                            .sort(Comparator.comparing(o -> o.idx));
                    int result = foods.get(i + (int)k).idx;
                    System.out.println("Practice.muziLive = " + result);
                    check = true;
                    break;
                }
            }
            eaters -= 1;
        }

        if (!check) {
            System.out.println("Practice.muziLive = " + -1);
        }
    }

    public static void main(String[] args) {
        adventureGuild(5, new int[]{2,3,1,2,2});
        multiplePlus("02984");
        multiplePlus("567");
        filpString("0001100");
        impossiblePrice(5, new int[]{3,2,1,1,9});
        selectBalls(8, 5, new int[]{1,5,4,3,2,4,5,2});
        muziLive(new int[]{3,1,2}, 5);
    }
}
