// LeetCode Problem: 238 - Product of Array Except Self
// Difficulty: Medium
// Link: https://leetcode.com/problems/product-of-array-except-self/

/**
 * TODO:
 * 1. Understand the problem: Return array where each element is product of all others
 * 2. Identify the approach: Use prefix and suffix products (no division, O(1) extra space)
 * 3. Implement the solution
 * 4. Test with edge cases (zeros, negatives, single element)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(1) excluding output array
 * 7. Optimize if possible
 */
class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // TODO: Implement your solution here
        int[] prefixProducts = new int[ nums.length ];

        for (int i = 0; i < nums.length; i++) {
            prefixProducts[ i ] = prefixProducts[ i - 1 ] * nums[ i - 1 ];
        }

        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixProducts[ i ] = prefixProducts[ i ] * suffixProduct;
            suffixProduct *= nums[ i ];
        }

        return prefixProducts;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // TODO: Add your test cases here
    }
}

