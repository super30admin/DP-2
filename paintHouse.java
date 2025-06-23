
//Time 0(n) space 0(n)

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // int[] dp = new int[nums.length];
        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1] + 0);//
        for(int i = 2;i< nums.length;i++)
        {
            int temp = curr;
            curr = Math.max(curr, nums[i]+prev);
            prev = temp;
        }
        return curr;
    }
}