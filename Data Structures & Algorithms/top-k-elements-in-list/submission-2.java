class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // 2. Buckets: index = frequency, value = list of numbers with that frequency
        // Max frequency is nums.length, so we need length + 1 buckets (ignore index 0)
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int number = entry.getKey();
            int f = entry.getValue();

            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(number);
        }

        // 3. Collect from highest frequency bucket downwards until we have k elements
        int[] result = new int[k];
        int idx = 0;

        for (int f = buckets.length - 1; f >= 0 && idx < k; f--) {
            if (buckets[f] == null) continue;

            for (int num : buckets[f]) {
                result[idx++] = num;
                if (idx == k) {
                    break;
                }
            }
        }

        return result;
    
    }
}
