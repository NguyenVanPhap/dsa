// LeetCode Problem: 347 - Top K Frequent Elements
// Difficulty: Medium
// Link: https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

/**
 * TODO:
 * 1. Understand the problem: Find k most frequent elements
 * 2. Identify the approach: Use HashMap + PriorityQueue or Bucket Sort
 * 3. Implement the solution
 * 4. Test with edge cases (k = 1, k = array length, all same elements)
 * 5. Analyze time complexity
 * 6. Analyze space complexity
 * 7. Optimize if possible
 */
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Min-Heap theo frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // loại phần tử có frequency nhỏ nhất
            }
        }

        int[] result = new int[ k ];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            result[ i++ ] = entry.getKey();
        }

        return result;
    }

    public int[] topKFrequeneUseBucketSort(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }


        List<Integer>[] bucket = new List[ nums.length + 1 ];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[ freq ].add(entry.getKey());
        }

        int[] result = new int[ k ];
        int i = 0;
        for (int freq = bucket.length - 1; freq >= 0 && i < k; freq--) {
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    result[ i++ ] = num;
                    if (i == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();


        // TODO: Add your test cases here
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(solution.topKFrequeneUseBucketSort(nums1, k1))); // Expected: [1, 2]
    }
}

