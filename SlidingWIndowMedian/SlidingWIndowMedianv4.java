import java.util.*;

public class SlidingWIndowMedianv4 {
    public static void main(String[] args) {
        System.out.print("[");
        SlidingWIndowMedianv4 instance = new SlidingWIndowMedianv4();
        double[] result = instance.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    // Heaps
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private Map<Integer, Integer> delayed = new HashMap<>();

    private int k;

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        int n = nums.length;
        double[] result = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        result[0] = getMedian();

        for (int i = k; i < n; i++) {
            addNum(nums[i]);
            removeNum(nums[i - k]);
            result[i - k + 1] = getMedian();
        }

        return result;
    }

    private void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        balanceHeaps();
    }

    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= maxHeap.peek()) {
            if (num == maxHeap.peek()) prune(maxHeap);
            else balanceHeaps(); // balance may be needed after removal
        } else {
            if (num == minHeap.peek()) prune(minHeap);
            else balanceHeaps();
        }

        balanceHeaps();
    }

    private void balanceHeaps() {
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
            prune(maxHeap);
        }

        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
            prune(minHeap);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) delayed.remove(num);
                heap.poll();
            } else {
                break;
            }
        }
    }

    private double getMedian() {
        if (k % 2 == 1) {
            return (double) maxHeap.peek();
        } else {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
        }
    }
}
