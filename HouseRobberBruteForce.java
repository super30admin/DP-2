// Brute force - recursion. Time complexity - O(2^n)

class Solution {
    public int rob(int[] nums) {
        return robHelper(nums, 0, 0);
    }
    
    private int robHelper(int[] nums, int idx, int amount) {
        // base
        if (idx >= nums.length) return amount;        
        // logic
        int maxAmtChooseCase = robHelper(nums, idx+2, amount + nums[idx]);
        int maxAmtNotChooseCase = robHelper(nums, idx+1, amount);
        return Math.max(maxAmtChooseCase, maxAmtNotChooseCase);
    }
}