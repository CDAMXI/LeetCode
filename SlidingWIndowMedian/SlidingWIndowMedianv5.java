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

    // Max heap stores the smaller half (left side), sorted in reverse
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // Min heap stores the larger half (right side)
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Map to store numbers that are scheduled to be removed lazily
    private Map<Integer, Integer> delayed = new HashMap<>();

    // Logical sizes (excluding delayed removals)
    private int maxHeapSize = 0;
    private int minHeapSize = 0;
    private int k;  // Window size

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        int n = nums.length;
        double[] result = new double[n - k + 1];

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        result[0] = getMedian();  // Store median of first window

        // Slide the window through the array
        for (int i = k; i < n; i++) {
            addNum(nums[i]);             // Add new element
            removeNum(nums[i - k]);      // Remove element that is no longer in the window
            result[i - k + 1] = getMedian();  // Store median of current window
        }

        return result;
    }

    // Add a number to one of the heaps
    private void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            maxHeapSize++;
        } else {
            minHeap.offer(num);
            minHeapSize++;
        }
        balanceHeaps();  // Maintain size invariant
    }

    // Remove a number lazily (schedule it for removal)
    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        // Adjust logical size
        if (num <= maxHeap.peek()) {
            maxHeapSize--;
            if (num == maxHeap.peek()) prune(maxHeap);
        } else {
            minHeapSize--;
            if (num == minHeap.peek()) prune(minHeap);
        }

        balanceHeaps();  // Rebalance after logical size change
    }

    // Keep the heaps balanced: maxHeapSize >= minHeapSize and size difference <= 1
    private void balanceHeaps() {
        // Move element from maxHeap to minHeap if it's too large
        while (maxHeapSize > minHeapSize + 1) {
            int moved = maxHeap.poll();
            prune(maxHeap);
            minHeap.offer(moved);
            maxHeapSize--;
            minHeapSize++;
        }

        // Move element from minHeap to maxHeap if it's too large
        while (minHeapSize > maxHeapSize) {
            int moved = minHeap.poll();
            prune(minHeap);
            maxHeap.offer(moved);
            minHeapSize--;
            maxHeapSize++;
        }

        // Clean up any delayed elements at the top of the heaps
        prune(maxHeap);
        prune(minHeap);
    }

    // Remove any numbers at the top of the heap that were delayed
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) delayed.remove(num);
                heap.poll();  // Remove the number from heap
            } else break;
        }
    }

    // Return the current median based on heap tops
    private double getMedian() {
        if (k % 2 == 1) {
            return (double) maxHeap.peek();  // Odd window size: middle element from maxHeap
        } else {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;  // Even: average of two middles
        }
    }
}
