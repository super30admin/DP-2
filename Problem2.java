// There are two approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

// Approach: Dynamic Programming
// Time Complexity : O(n*T) 
//      n : number of coins
//      T : Target amount
// Space Complexity : O(n*T)
//      n : number of coins
//      T : Target amount   
class Problem2DP1 {

    //** find all possible combinations */
    public int change(int amount, int[] coins) {

        // initialize dp 
        // row - from 0 to coins demoniation (coins+1)
        // col - from 0 to amount (amount+1)
        int[][] dp = new int[coins.length+1][amount+1];
        
        // for Amount=0 we have only one way
        for(int i=0;i<=coins.length;i++)
            dp[i][0]=1;
        
        // for Zero denomination
        for(int j=1; j<=amount;j++)
            dp[0][j] = 0;
        
        // iterate coins
        for(int i=1;i<=coins.length;i++){
            
            // iterate amount
            for(int j=1; j<=amount;j++){
                
                // if amount is less than coin denomination
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                // possible to make target
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    // number of ways we achieved previously + remining amount ways
            }
        }
        
        return dp[coins.length][amount];
    }
}
// Approach: Dynamic Programming with less space
// Time Complexity : O(n*T) 
//      n : number of coins
//      T : Target amount
// Space Complexity : O(T)
//      T : Target amount  
class Problem2DP2 {

    //** find all possible combinations */
    public int change(int amount, int[] coins) {

        // using single array from 0 to amount
        int[]dp = new int[amount+1];

        // for Amount=0
        dp[0]=1;
        
        // for Amount>0
        for(int j=1; j<=amount;j++)
            dp[j] = 0;
        
        //iterate coins
        for(int i=1;i<=coins.length;i++){
            
            // iterate amount
            for(int j=1; j<=amount;j++){
                
                // if amount can be made from current denomination
                if(j >= coins[i-1])
                    dp[j] += dp[j-coins[i-1]];
                    // add previous way + new ways
            }
        }
        
        // return total ways
        return dp[amount];
    }
}