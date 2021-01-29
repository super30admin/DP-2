// Time Complexity : O(nk) - n=amount value  
// Space Complexity : O(k) - k=no. of different coins
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class CoinChange2 {
    public int change(int amount, int[] coins) {

        int n = amount + 1, m = coins.length;

        int[] dp = new int[n];

        // initialize the dp array
        dp[0] = 1;

        // see if there are new ways of getting
        // the amount adding one coin value at a time
        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j < n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[n - 1];

    }
}
