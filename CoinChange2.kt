// In this problem, we use DP bottom up approach to calculate the number of ways to make the amount. We use a 1D array to store the number of ways. 
// If the amount is less than the coin value, we carry forward the previous value. Otherwise, we add the number of ways to make the amount by including the coin.
// Time Complexity: O(m*n) where m is the number of coins and n is the amount.
// Space Complexity: O(n) where n is the amount.

class Solution {
    fun change(amount: Int, coins: IntArray): Int {
    val m = coins.size
    val n = amount

    val dp = IntArray(n + 1)
    dp[0] = 1

    for(i in 1..m) {
        for(j in 0..n) {
            if(j < coins[i-1]) {
                dp[j] = dp[j]
            } else {
                dp[j] = dp[j] + dp[j - coins[i - 1]]
            }
        }
    }

    return dp[n]
}
}
