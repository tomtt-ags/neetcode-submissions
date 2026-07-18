public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Min-heap ordered by squared distance to origin
        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparing(
                p -> p[0]*p[0] + p[1]*p[1]
            ));

        // Add all points to the heap
        for (int[] p : points) {
            pq.offer(p);
        }

        // Extract k closest points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}

