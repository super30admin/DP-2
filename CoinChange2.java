/*
518. Coin Change 2 - MEDIUM
https://leetcode.com/problems/coin-change-2/

Approach: Why is this a DP problem?
i. Choice to select or not-select every coin

1. For every coin, if the coin is greater than the amount we are trying to make,
    we cannot choose this coin, and the number of solutions is the number of ways,
    we can make the amount with the set of coins not containing this coin.
2. If the coin's amt is less than the amount we are trying to make, then again we have 2 choices -
    If we do not choose, the solution is - the solution to the problem of coins not containing this coin,
    and the amt remains the same => [i-1][amt]
3. If we choose this coin, since we have an infinite supply of coins, we can again choose from the set
    containing this coin, but with a smaller amount => [i-1][amt - amt_of_coin]

TC: O(n * a) => where n: no of coins, a = amount
SC: O(n * a) => dp array of size [n+1][a+1]
*/

class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j]; 
                } else {   
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];   
                }                
            }
        }
        
        // Print DP array
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return dp[coins.length][amount];
    }

    public static void main(String args[]) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        System.out.println(change(amount, coins));
    }
}