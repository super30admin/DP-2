// House robber pattern for dynamic programming. Similar to fibonacci

// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int rob(int[] nums) {  
        if (nums.length == 1) {
            return nums[0];
        }
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        
        return curr;
    }
}