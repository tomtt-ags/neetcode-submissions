
class MedianFinder {
    private final PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> right = new PriorityQueue<>();

    public void addNum(int num) {
        left.offer(num);

        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.offer(left.poll());
        }

        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size() + 1) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.size() > right.size() ? left.peek() : right.peek();
    }
}

