package SearchA2DArray;

public class SearchA2DArrayv2 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target)); // true
    }

    /**
     * Binary search treating the 2D matrix as a sorted 1D array.
     * Time: O(log(m*n)), Space: O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Guard clauses for empty inputs
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / n;
            int c = mid % n;
            int val = matrix[r][c];

            if (val == target) return true;
            if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
