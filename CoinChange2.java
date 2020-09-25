// Time Complexity : O(n*c), amount n, c is #coin options
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int change(int amount, int[] coins) {
      int[] dp = new int[amount + 1];
      dp[0] = 1;
  
      for (int coin : coins) {
        for (int x = coin; x < amount + 1; ++x) {
          dp[x] += dp[x - coin];
        }
      }
      return dp[amount];
    }
  }

// Time Complexity : O(n*c), amount n, c is #coin options
// Space Complexity : O(n*c) for the memoization table

class Solution {
    
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];
        return helper(amount, coins, 0, memo);
    }
    
    private int helper(int amount, int[] coins, int idx, int[][] memo){
        if(amount==0) return 1;
        if(idx>=coins.length) return 0;
        
        if(memo[idx][amount]!=0) return memo[idx][amount];
        
        int ways1 = 0;
        if(amount>=coins[idx])
            ways1 = helper(amount-coins[idx], coins, idx, memo);
        
        int ways2 = helper(amount, coins, idx+1, memo);
        memo[idx][amount] = ways1 + ways2;
        return ways1+ways2;
    }
}