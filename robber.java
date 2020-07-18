// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : took help from geeksforgeeks

// First 3 cases handle the scenarios when we have 0 or 1 or 2 houses
// Then for more than 3 houses, at every house we have to take a decision to rob that house or not. We take this decision
//   by calculating maximum of ( money robbed till 2 houses before that plus money in that house or money robbed till one house
//    before it)


class Solution {
    public int rob(int[] nums) {

        if(nums.length==0 || nums==null)
            return 0;

        if(nums.length==1)
            return nums[0];

        if(nums.length==2)
            return Math.max(nums[0],nums[1]);


        int[] dp = new int[nums.length];

        //Base Case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i =2; i< nums.length ; i++)
        {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);

        }

        return dp[nums.length-1];

    }
}
