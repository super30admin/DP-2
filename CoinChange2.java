// Time Complexity : O(n * amount)
// Space Complexity : O(n * amount)
// Did this code successfully run on Leetcode? : Yes
// Any problem you faced while coding this? : No
public class CoinChange2 {
    // Function to return number of combinations to make 'amount' using given coins
    public int getCount(int[] coins, int amount){
        int n = coins.length;
        int m = amount;

        // dp[i][j] = number of ways to make j using first i coins
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;

        // Build DP table
        for (int i=1;i<n+1;i++){
            for (int j=0;j<m+1;j++) {
                // If current coin is larger than target amount j,
                // we cannot use this coin, carry forward result
                if (coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else {//ways including current coins and excluding current coins
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][m]; // Return number of combinations using all n coins to make 'amount'
    }

    public  static void main(String args[]) {
        CoinChange2 cg = new CoinChange2();
        int count = cg.getCount(new int[]{1,2,5}, 5);
        System.out.println(count);
    }
}
