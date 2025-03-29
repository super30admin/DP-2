/* Using DP matrix: Time complexity - O(m*n) & Space complexity - O(m*n) */

/* Using array: Time complexity - O(m*n) & Space complexity - O(n)
 * m - coins length, n - amount
 */

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]) //amount < denomination of the coin
                {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}

/* Using recursive logic: Time complexity - 2^(m+n) & Space complexity - (m+n)
 * m - coins length, n - amount
 */
/*
class Solution {
    int count;
    public int change(int amount, int[] coins) {
        this.count = 0;
        helper(coins, 0, amount);
        return count;
    }

    private void helper(int[] coins, int i, int amount){
        //base case
        if(amount == 0){
            count++;
            return;
        }

        if(amount < 0 || i == coins.length){
            return;
        }

        //don't choose
        helper(coins, i+1, amount);

        //choose
        helper(coins, i, amount - coins[i]);
    }
}
*/