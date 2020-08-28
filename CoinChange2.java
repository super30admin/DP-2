class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        // Time Complexity: O(n^2) or O(mn) - coins and amount
        // Space Complexity: O(mn)

        int[][] dp = new int[coins.length+1][amount+1];
        
    //Filling first column values as 1 since [] is also one way to make amount = 0
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
    // Filling first row values as 0 since with empty or 0 coin, amt > 0 cant be made
        for(int i = 1; i <= amount; i++){
            dp[0][i] = 0;
        }
        
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
            // Copying upper cell values when amount is less than coin denomination
                if( j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                } else
            // For amount >= denomination
                    dp[i][j] = dp[i-1][j] + dp[i][ j - coins[i - 1]];
            }
        }
        
        return dp[coins.length][amount]; // covers edge case 0
    }
}
