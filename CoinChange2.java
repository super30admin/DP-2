/**
 * iterative
 * 
 * time: 2^(n*m) n: no. of coins, m: amount 
 * space: 2^(n*m)
 * 
 * No. of all combinations that can make up the amount 
 * 
 * Approach:
 * Use the not choose or choose approach
 * 1. case1 => count the no. of sub cases if the current denomination not choosen
 * 2. case2 => count the no. of sub cases if the current denomination choosen
 * 3. Repeat the above in the recursive tree:
 *      if the amount at leaf == 0 then return 1 -- valid case
 *      if the amount < 0 then return 0 -- invalid case as the amount cannot be made up using those coin combinations
 * 
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
 * 
 * Approach:
 * 1. plot the amounts on the x grid (0 to amount)
 * 2. plot the coin denominations on the y grid ( 0 to coin denominations)
 * 3. Fill the table such that In how many ways can we make the amount using each denomination
 * 4. Add a dummy 0 row for simplicity
 * 5. if the amount is less than the coin denomination 
 *      then copy same from 1 row above
 *    else
 *      the amount from previous row, same column 
 *          +
 *      the amount from the current row, going n-steps back from the current column
 *          (n => current row coin denomination)
 * 
 * To reach this approach draw the iterative tree first:
 * Eg. 
 * 
 *   [ 1 , 2 ]
 *      0 / \ 1
 *       /   \
 *      / 0   \    0
 *     [1]    [1,2]
 * 
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
 * 
 * Approach:
 * Using the same previous approach
 * To save space we can just use 1D array for storing the dp
 * because the columns till the coin denomination stay the same (use the same data from 1 row above for resp. columns)
 * 
 * Note: 
 * the overwrite operation in the if condition is unnecessary 
 *  and is only kept for illustration purpose
 *  instead we can just have the below:
 *  
 *  if(j >= coins[i-1]){
 *     dp[j] = dp[j] + dp[j-coins[i-1]]; 
 *  }
 * 
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

