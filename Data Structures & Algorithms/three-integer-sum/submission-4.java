class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort once
        Arrays.sort(nums);

        List<List<Integer>> out = new ArrayList<>();
        HashSet<List<Integer>> test = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
           
            // get *all* pairs that work with nums[i]
            List<int[]> pairs = twoSum(nums[i], nums, i);

            for (int[] tes : pairs) {
                List<Integer> outt = Arrays.asList(
                    nums[tes[0]],
                    nums[tes[1]],
                    nums[i]
                );
                // sort the triplet so HashSet can dedupe
                Collections.sort(outt);
                test.add(outt);
            }
        }

        out.addAll(test);
        return out;
    }

    // now returns *all* valid pairs (by index) instead of just one
    public List<int[]> twoSum(int target, int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        int realTarget = -target;
        List<int[]> res = new ArrayList<>();

        while (i < j) {
            if (i == k) {
                i++;
                continue;
            }
            if (j == k) {
                j--;
                continue;
            }
            if (i >= j) break;

            int sum = nums[i] + nums[j];

            if (sum > realTarget) {
                j--;
            } else if (sum < realTarget) {
                i++;
            } else {
                // found one pair
                res.add(new int[]{i, j});
                i++;
                j--;

                // skip duplicates to avoid repeating the same pair
                // while (i < j && nums[i] == nums[i - 1]) i++;
                // while (i < j && nums[j] == nums[j + 1]) j--;
            }
        }
        return res;
    }
}

