// Time Complexity : O(m*n) where m is the number of coins and n is the amount to reach
// Space Complexity : O(n) where n is the amount to reach
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach:

// Consider a 2d dp array where each dp[i][j] gives the num of ways to reach j using coins upto i index
// so dp [i][j] should be sum of choose and not choose possibility.
//1) Dont choose means whatever was the previous value will be continued
//2)choose means we will have a new target which is equal to target-coin and we will go to dp[complements] and add it 
class Solution {
    public int change(int amount, int[] coins) {

        // here first element is = 1 because we have no coins and num of ways to reach 0
        // is equal to 1(empty list) and the rest of the elements are set as 0 as there
        // are no possible ways to reach it
        // X |0 1 2 3 4 5 6 7
        // 0 |1 0 0 0 0 0 0 0 --> first row
        // 1 |1 1 1 1 1 1 1 1
        // 2 |1 1 2 2 3 3 4 4
        // 5 |1 1 2 2 3 4 5 6

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 0);
        Arrays.sort(coins);
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                // we only go inside this block if the coin is useful i.e (bigger than the
                // current target if not then skip this because it is useless)
                if (i >= coin) {
                    // dont choose is dp[i] and choose is dp[i-coin]
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }
}