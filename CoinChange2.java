// Time Complexity: O(m * n)
// m = number of different coins
// n = total amount
// For each of the m coins, we iterate through up to n amounts

// Space Complexity: O(n)
// A 1D dp array of size (n + 1) is used to store the number of ways to form each amount

// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Initially found it tricky to decide the loop order (coins outer, amount inner).

/*Approach : I initialized dp[0] = 1 because there's 1 way to make amount 0 — by choosing no coins.
Then, for each coin, I iterated from coin to amount, and updated the number of ways to make each amount.
At each step i, I added dp[i - coin] to dp[i], which means:
"If I know how to make (i - coin), then by adding this coin, I can also make i."
This ensures we're counting unique combinations and not permutations, since we're fixing the coin order.*/

public class CoinChange2 {
    public int findPossibilities(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 1; // 1 way of making amount 0 is by choosing no coins at all

        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[amount];
    }
}
