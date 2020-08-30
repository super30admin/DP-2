// Time Complexity : 
//For 2D matrix and 1D array : O(A * C) where A = amount, C = coins length.
// Space Complexity :
//For 2D matrix and 1D array: O(A * C * N) where A = amount, C = coins length, N = length of 2D matrix/1D array.
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Inititially we fill the amount row with 0 since there are 0 ways to make up to an amount with coin 0.
//2. Then when we have the coin length is less more than the amount then add the previously computed value and the deficit value of the coin and the amount i.e dp[i - 1][j] + dp[i][j - coins[i - 1]].
//3. If the coin value is les than the amount then we  have no choice but to fill the value with the previously computed value i.e  dp[i - 1][j].
//4 And finally we return the last value in the matrix, i.e dp[coins][matrix].



public class CoinChange2 {
    public int change(int amount, int[] coins) {
        // USING 1D ARRAY;
        // int dp[] = new int[amount + 1];

        // Arrays.fill(dp, 0);
        // dp[0] = 1;

        // for(int i = 1; i <= coins.length; i++){
        // for(int j = 1; j <= amount; j++){
        // if(j >= coins[i - 1]){
        // dp[j] = dp[j] + dp[j - coins[i - 1]];
        // }
        // }
        // }
        // return dp[amount];

        // USING 2D MATRIX
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++)
            dp[i][0] = 1;
        for (int j = 1; j <= amount; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String args[]) {
        CoinChange2 obj = new CoinChange2();
        int amount = 7;
        int[] coins = { 1, 2, 5 };
        System.out.println(obj.change(amount, coins));
    }
}