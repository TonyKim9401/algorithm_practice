package ndb.implementation;

public class NightInRoyal {
    public static void main(String[] args) {

        String position = "a1";

        // x = 0, y = 1
        int[] intPos = {position.charAt(0) - 'a' + 1, position.charAt(1) - '0'};

        int[][] direction = {
                //북                 남
                {-1, -2}, {1, -2}, {-1, 2}, {1, 2},
                //동                 서
                {2, 1}, {2, -1}  , {-2, 1}, {-2, -1}};
        // 최소 좌표는 1, 최대 좌표는 8

        int count = 0;

        for(int i = 0; i < direction.length; i++) {
            int[] move = direction[i];
            int dx = intPos[0] + move[0];
            int dy = intPos[1] + move[1];

            if (dx > 0 && dx < 9 && dy < 9 && dy > 0) {
                count += 1;
            }
        }

        System.out.println(count);


        /**
         최대 가능성 8에서 각 모서리에 있으면 2씩 빼주면 됨..
         count = 8

         if row == 1 or row == 2 or row == 7 or row == 8:
         count -= 2

         if column == 1 or column == 2 or column == 7 or column == 8:
         count -= 2


         */
    }
}
