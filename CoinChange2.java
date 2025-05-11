/**
 * Greedy Approach
 * 
 * Recursion
 * Time Complexity = O(2^m+n)
 * m = total amount
 * n = total coins
 * We either choose or no choose, so we have 2 posibilites.
 * Also, we will have a decision tree of depth m Amount.
 */
class CoinChange2 {
    int count  = 0;
    public int change(int amount, int[] coins) {
        this.count = 0;
        helper(amount, coins, 0);
        return count;
    }

// We need Amount, Coins and index[Whats the coin position.]
    private void helper(int amount, int[] coins, int i){
        //Base Case
        if(amount == 0){
            count++;
            return;
        }

        if(amount < 0 || i == coins.length)
            return;

        //Dont choose the coin
        helper(amount, coins, i+1);

        //Choose Coin
        helper(amount-coins[i], coins, i);
    }
}


/**
 * Dynamic Programming
 * We identifed repeated sub problems 
 * So, this can be solved using tabulation
 * There 2 decision making parametes
 * 1. Amount
 * 2. Coins [Choose/ No Choose]
 *
 * Time Complexity = O(n*m) => Iterating over the matrix;
 * Space Complexity = O(n*m) => Matrix
 */

 class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int [][] matrix = new int[m+1][n+1];

        for(int i=0; i<=n; i++){
            matrix[0][i] = 0;
        }

        for(int i=0; i<=m; i++){
            matrix[i][0] = 1;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(j < coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                }
                else{
                int sub1 = matrix[i-1][j];
                int sub2 = matrix[i][j-coins[i-1]];
                matrix[i][j] = sub1 + sub2;
                }
            }
        }
        return matrix[m][n];
    }
}