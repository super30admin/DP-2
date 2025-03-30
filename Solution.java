class Solution {
    public int rob(int[] nums) {
        int profit = 0;
        return helper(nums, 0, profit);

    }

    int helper(int[] nums, int i, int profit)
    {
        if(i >= nums.length){
            return profit;
        }
        return Math.max(
                helper(nums, i+1, profit)
                , helper(nums, i+2, profit+nums[i]));

    }
}