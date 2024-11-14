public class Main {
    public static void main(String[] args) {
        int[][] matrix2D = new int[3][3];
        for(int i = 0; i < matrix2D.length; i++){
            for(int j = 0; j < matrix2D.length; j++) {
                matrix2D[i][j] = 0;
            }
        }


        for(int row[] : matrix2D){
            for(int item : row){
                System.out.println(item);
            }
        }
    }
}