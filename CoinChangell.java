// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach

class CoinChangell {
public int change(int amount, int[] coins) {

    int[] dp = new int[amount+1];
 
    dp[0] = 1;
 
    for(int c : coins)
 
      for(int i=c;i<=amount;i++)
 
        dp[i] += dp[i - c];
 
    return dp[amount];
 
  }
 
 }
