package ndb.greedy;

import java.util.*;

public class MuziLive {

    static class Food {
        int time;
        int idx;
        Food(int t, int i) {
            this.time = t;
            this.idx = i;
        }
    }
    static class Solution {
        public int solution(int[] food_times, long k) {

            List<Food> foods = new ArrayList<>();
            int n = food_times.length;
            for (int i = 0; i < food_times.length; i++) {
                Food food = new Food(food_times[i], i + 1);
                foods.add(food);
            }

            foods.sort((o1, o2) -> {
                return o1.time - o2.time;
            });

            int pretime = 0;
            int i = 0;

            for (Food f : foods) {
                long diff = f.time - pretime;
                if (diff != 0) {
                    long spend = diff * n; // 1 * 6
                    if (spend <= k) {
                        k -= spend;
                        pretime = f.time; // 1
                    } else {
                        k %= n;
                        foods.subList(i, food_times.length).sort((o1, o2) ->{
                           return o1.idx - o2.idx;
                        });
                        return foods.get(i + (int)k).idx;
                    }
                }
                i += 1;
                n -= 1;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{3, 5, 1, 6, 5, 3}, 20l);
//        int result = solution.solution(new int[]{3, 3, 3}, 8l);
        System.out.println(result);
    }

}
