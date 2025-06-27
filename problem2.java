// Time Complexity : O(amount*n) n is the length of coins
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I made an array of amount+1 size - each index tells the number of ways to make this amount.
// 0 can be made in 1 way - every coin is 0.
// for each coin, I check what amounts can be made - > I iterate through coins and then through amounts greater than coin values, I update the total ways amount can be made by adding the ways amount - coin could have been made - this gives all unique ways.
// Finally, I return the value at index amount. 

class Solution {
    public int change(int amount, int[] coins) {
        int [] totalWaysToMakeAmount = new int[amount+1];
        totalWaysToMakeAmount[0]=1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                totalWaysToMakeAmount[i] += totalWaysToMakeAmount[i - coin];
            }
        }
        return totalWaysToMakeAmount[amount];
    }
}