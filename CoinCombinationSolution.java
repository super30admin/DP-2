// Time Complexity : O(n^2) // for loop within for loop, once to iterate for each coin type, other loop to iterate for amount
// Space Complexity : O(n) // 1d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class CoinCombinationSolution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // 1d array to store amount ONLY since we only care TOTAL number of combinations that make this amount
        dp[0] = 1; // only 1 combination to make amount 0 regardless of type of coin, ie. NOT select; initialize since we need starting point
        
        for (int coin : coins){ // iterate for each type of coin
            for (int i = coin; i <= amount; i++){ // coin amount is the MINIMUM 
                dp[i] += dp[i-coin]; // since 1d array, we want to keep accumulating the total number of combos, by adding the combos from all prev coin types; we add dp[i-coin] as pattern we observed (draw out matrix) to get number of combos with current type of coin AND prev types of coins
            }
        }
        return dp[amount]; // return value at the final amount (we kept accumulating to get updated total of all combos)
    }
}