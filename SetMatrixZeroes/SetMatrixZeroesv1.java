package SetMatrixZeroes;

public class SetMatrixZeroesv1 {
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 0, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("Matriz original:");
        printMatrix(matrix);

        setZeros(matrix);

        System.out.println("\nMatriz después de setZeros:");
        printMatrix(matrix);
    }

    public static void setZeros(int[][] matrix){
        int row = -1, col = -1;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){ row = i; col = j;}
            }
        }

        for(int i = 0; i < matrix.length; i++){
            matrix[row][i] = 0;
            matrix[i][col] = 0;
        }

        if(matrix[row][matrix[row].length - 1] != 0){
            matrix[row][matrix[row].length - 1] = 0;
        }
    }

    private static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
