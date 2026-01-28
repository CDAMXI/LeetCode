package SetMatrixZeroes;

public class SetMatrixZeroesv3 {
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 0, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("Matriz original:");
        printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("\nMatriz después de setZeroes:");
        printMatrix(matrix);
    }
    private static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public static void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    if (rows == 0) return;
    int cols = matrix[0].length;

    boolean firstRowZero = false;
    boolean firstColZero = false;

    // Detectar ceros en primera fila y primera columna
    for (int j = 0; j < cols; j++) firstRowZero |= (matrix[0][j] == 0);
    for (int i = 0; i < rows; i++) firstColZero |= (matrix[i][0] == 0);

    // Marcar usando primera fila/columna
    for (int i = 1; i < rows; i++) {
        int[] row = matrix[i];
        for (int j = 1; j < cols; j++) {
            if (row[j] == 0) {
                row[0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // Aplicar marcas
    for (int i = 1; i < rows; i++) {
        int[] row = matrix[i];
        boolean zeroThisRow = (row[0] == 0);
        for (int j = 1; j < cols; j++) {
            if (zeroThisRow || matrix[0][j] == 0) {
                row[j] = 0;
            }
        }
    }

    // Zerar primera fila/col si tocaba
    if (firstRowZero) {
        for (int j = 0; j < cols; j++) matrix[0][j] = 0;
    }
    if (firstColZero) {
        for (int i = 0; i < rows; i++) matrix[i][0] = 0;
    }
}
}
