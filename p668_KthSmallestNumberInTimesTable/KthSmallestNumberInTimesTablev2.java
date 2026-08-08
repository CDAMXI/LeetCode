package p668_KthSmallestNumberInTimesTable;

public class KthSmallestNumberInTimesTablev2 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int k = 5;
        KthSmallestNumberInTimesTablev2 solution = new KthSmallestNumberInTimesTablev2();
        int result = solution.findKthNumber(m, n, k);
        System.out.println(result);
    }
    
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Contamos cuántos números son <= mid
            if (count(mid, m, n) >= k) {
                // Si hay al menos k números, la respuesta podría ser mid o menor
                high = mid;
            } else {
                // Si hay menos de k números, la respuesta debe ser mayor que mid
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    // Función auxiliar para contar elementos
    private int count(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // Math.min garantiza que no contemos más elementos de los que tiene la columna (n)
            count += Math.min(mid / i, n);
        }
        return count;
    }
}
