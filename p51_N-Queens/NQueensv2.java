import java.util.*;

class NQueensv2 {
    private int n;
    private int[] queens;       // queens[row] = columna de la reina en esa fila
    private boolean[] cols;     // columnas ocupadas
    private boolean[] diag1;    // diagonales con row + col constante
    private boolean[] diag2;    // diagonales con row - col constante (desplazadas n - 1)
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        this.cols = new boolean[n];
        this.diag1 = new boolean[2 * n - 1];
        this.diag2 = new boolean[2 * n - 1];
        this.res = new ArrayList<>();
        backtrack(0);
        return res;
    }

    private void backtrack(int row) {
        if (row == n) {
            res.add(build());
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            queens[row] = col;
            cols[col] = diag1[d1] = diag2[d2] = true;
            backtrack(row + 1);
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> build() {
        List<String> solution = new ArrayList<>(n);
        char[] line = new char[n];
        for (int r = 0; r < n; r++) {
            Arrays.fill(line, '.');
            line[queens[r]] = 'Q';
            solution.add(new String(line));
        }
        return solution;
    }
}
