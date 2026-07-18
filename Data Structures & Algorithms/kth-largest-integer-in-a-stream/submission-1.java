class KthLargest {
    int max;
    ArrayList<Integer> heap;

    public KthLargest(int k, int[] nums) {
        max = k;
        heap = new ArrayList<>();
        heap.add(0); // dummy at index 0

        for (int x : nums) {
            heapAdd(x);
            if (heap.size() - 1 > max) heapPop(); // NOTE: -1 because dummy
        }
    }

    public int add(int val) {
        heapAdd(val);
        if (heap.size() - 1 > max) heapPop();
        return heap.get(1);
    }

    private void heapAdd(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int temp = heap.get(i / 2);
            heap.set(i / 2, heap.get(i));
            heap.set(i, temp);
            i /= 2;
        }
    }

    public void heapPop() {
        if (heap.size() == 2) { // only one real element
            heap.remove(heap.size() - 1);
            return;
        }
        heap.set(1, heap.remove(heap.size() - 1));

        int i = 1;
        while (2 * i < heap.size()) {
            int left = 2 * i;
            int right = 2 * i + 1;

            int smallest = left;
            if (right < heap.size() && heap.get(right) < heap.get(left)) {
                smallest = right;
            }

            if (heap.get(i) <= heap.get(smallest)) return;

            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);

            i = smallest;
        }
    }
}
