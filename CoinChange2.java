// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(m * n) since we are iterating through the dp matrix 
//Space Complexity: O(m * n) since we are using extra dp matrix 

public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        
        int[][] dp = new int[coins.length + 1] [amount + 1];
        
        for(int i = 0; i < dp.length; i++){ // Fill all the rows with 1;
           dp[i][0] = 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(coins[i-1] > j){ // Until amount is less than denomination fill up the earlier values
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    // Number of ways for choosing current denomination is equal to sum of ways for earlier denomination  
                    // and the amount that is denomination steps behind the current element
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }