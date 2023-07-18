package programmers;

public class ParkWalking {
    static class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] curLoc = new int[2];

            for (int i = 0; i < park.length; i++) {
                boolean check = true;
                for (int j = 0; j < park[i].length(); j++) {
                    if (park[i].charAt(j) == 'S') {
                        curLoc[0] = i;
                        curLoc[1] = j;
                        check = false;
                        break;
                    }
                }
                if (!check) break;
            }

            int widthMax = park[0].length() - 1; // xMax
            int heightMax = park.length - 1;     // yMax

            // park[y].charAt(x) cur[y, x]
            for(int i = 0; i < routes.length; i++) {
                String[] route = routes[i].split(" ");
                String way = route[0];
                int move = Integer.parseInt(route[1]);
                int[] tempLoc = new int[]{curLoc[0], curLoc[1]};
                boolean check = true;

                if (way.equals("E")){ //x늘리기
                    if (curLoc[1] + move > widthMax) continue;

                    for (int j = 1; j <= move; j++) {
                        curLoc[1]++;
                        if(park[curLoc[0]].charAt(curLoc[1]) == 'X') {
                            check = false;
                            break;
                        }
                    }
                } else if (way.equals("W")){ //x줄이기
                    if (curLoc[1] - move < 0) continue;
                    for (int j = 1; j <= move; j++) {
                        curLoc[1]--;
                        if(park[curLoc[0]].charAt(curLoc[1]) == 'X') {
                            check = false;
                            break;
                        }
                    }
                } else if (way.equals("N")){ //y늘리기
                    if (curLoc[0] - move < 0) continue;
                    for (int j = 1; j <= move; j++) {
                        curLoc[0]--;
                        if(park[curLoc[0]].charAt(curLoc[1]) == 'X') {
                            check = false;
                            break;
                        }
                    }
                } else if (way.equals("S")){ //y줄이기
                    if (curLoc[0] + move > heightMax) continue;
                    for (int j = 1; j <= move; j++) {
                        curLoc[0]++;
                        if(park[curLoc[0]].charAt(curLoc[1]) == 'X') {
                            check = false;
                            break;
                        }
                    }
                }

                // 움직이는게 실패할 경우 되돌리기
                if(!check) {
                    curLoc = tempLoc;
                }
            }

            return curLoc;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"});
//        int[] result = solution.solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"});
//        int[] result = solution.solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
