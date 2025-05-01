import java.util.*;

public class SlidingWIndowMedianv5 {
    public static void main(String[] args) {
        System.out.print("[");
        SlidingWIndowMedianv5 instance = new SlidingWIndowMedianv5();
        double[] result = instance.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private Map<Integer, Integer> delayed = new HashMap<>();
    private int maxHeapSize = 0, minHeapSize = 0, k;

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
            maxHeapSize++;
        } else {
            minHeap.offer(num);
            minHeapSize++;
        }
        balanceHeaps();
    }

    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= maxHeap.peek()) {
            maxHeapSize--;
            if (num == maxHeap.peek()) prune(maxHeap);
        } else {
            minHeapSize--;
            if (num == minHeap.peek()) prune(minHeap);
        }

        balanceHeaps();
    }

    private void balanceHeaps() {
        // Ensure size property: maxHeapSize >= minHeapSize and difference <= 1
        while (maxHeapSize > minHeapSize + 1) {
            int moved = maxHeap.poll();
            prune(maxHeap);
            minHeap.offer(moved);
            maxHeapSize--;
            minHeapSize++;
        }

        while (minHeapSize > maxHeapSize) {
            int moved = minHeap.poll();
            prune(minHeap);
            maxHeap.offer(moved);
            minHeapSize--;
            maxHeapSize++;
        }

        prune(maxHeap);
        prune(minHeap);
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) delayed.remove(num);
                heap.poll();
            } else break;
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
