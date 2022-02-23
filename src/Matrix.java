class Solution5 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                System.out.print(answer[i][j] + "\t");
            }
            System.out.println();
        }
        return answer;
    }
}

public class Matrix {
    public static void main(String[] args) {
        Solution5 sol5 = new Solution5();
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        sol5.solution(arr1,arr2);
    }
}
