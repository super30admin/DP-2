/**
 * iterative
 * 
 * time: 2^(n*m) n: no. of coins, m: amount 
 * space: 2^(n*m)
 */
class Problem23 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        
        return helper(amount, coins, 0);
    }
    
    public int helper(int amount, int[] coins, int index){
        
        // base
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;
        
        // logic
        // dont choose
        int case1 = helper(amount, coins, index+1);
        // choose
        int case2 = helper(amount-coins[index], coins, index);
            
        return case1 + case2;
    }
}

/**
 * DP
 * 
 * time: O(n*m)
 * space: O(n*m)
 */
class Problem23Approach1 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        
        int[][] dp = new int[coins.length+1][amount+1]; // +1 for 0 row and column
        
        dp[0][0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j < coins[i-1]){   // if amount is less than coin denomination 
                                    //copy from 1 row above
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];         
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}

/**
 * 
 * time: O(n*m)
 * space: O(n)
 */
class Problem23Approach2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        
        int[] dp = new int[amount+1]; // +1 for 0 row and column
        
        for(int i = 1; i <= coins.length; i++){
            dp[0] = 1;
            
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){   // if amount is less than coin denomination 
                                    // overwrite from 1 row above
                    dp[j] = dp[j];  // this not needed, just for explanation
                } else{
                    dp[j] = dp[j] + dp[j-coins[i-1]];         
                }
            }
        }
        
        return dp[dp.length-1];
    }
}

