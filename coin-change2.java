// TC: O(n*amount)
// SC: O(amount)

// APproach: Pick and stay at the same index or else move to next index.


class Solution {
  public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length][amount+1];
    for(int[] arr: dp)
      Arrays.fill(arr, -1);
    int ans = solve(coins, 0, amount, 0, dp);
    return ans == Integer.MAX_VALUE-1 ? -1 : ans;

  }

  private int solve(int[] arr, int idx, int amount, int ans, int[][] dp) {

    if(amount == 0) {
      return 1;
    }

    if(idx == arr.length || amount < 0)
      return 0;

    if(dp[idx][amount] != -1)
      return dp[idx][amount];


    int pick = ans + solve(arr, idx, amount-arr[idx], ans, dp);

    int notpick = ans + solve(arr, idx+1, amount, ans, dp);

    return dp[idx][amount] = pick + notpick;

  }
}