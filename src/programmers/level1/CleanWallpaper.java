package programmers.level1;

public class CleanWallpaper {
    static class Solution {
        public int[] solution(String[] wallpaper) {

            int[][] check = new int[wallpaper.length][wallpaper[0].length()];

            int xMin = wallpaper[0].length();    //x 최소
            int yMin = wallpaper.length;;  // y 최소
            int xMax = 0; // x 최대
            int yMax = 0;   //y 최대

            int curX = 0;
            int curY = 0;

            for(int i = 0; i < wallpaper.length; i++){
                String x = wallpaper[i];
                for(int j = 0; j < x.length(); j++) {
                    curX = j;
                    curY = i;
                    char value = x.charAt(j);
                    if (value == '#') {
                        if (xMin > curX) xMin = curX;
                        if (yMin > curY) yMin = curY;
                        if (xMax < curX) xMax = curX;
                        if (yMax < curY) yMax = curY;
                    }
                }
            }
            return new int[]{yMin, xMin ,yMax+1, xMax + 1};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"..", "#."});
//        int[] result = solution.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
