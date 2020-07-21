//Problem: 518. Coin Change 2
/** 3 Pointer Approcach: 
 * Initiate number of combinations array with the base case "no coins".
 * dp[0] = 1, and all the rest = 0.
 * Loop over the coins 
 * For each coin, loop over all amounts from 0 to amount:
 * for each amount x, compute the number of combinations: dp[x] += dp[x - coin] + dp[previous coin value for same amount]; . 
 */ 
//
//time Complexity :
// O(Amount * Coins) 

// Space Complexity :
// O(Amount * Coins)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

class Problem2 {
    public int change(int amount, int[] coins) {
        
        
        int rowcoins = coins.length+1;
        int colamounts  = amount+1;
        
        int[][] dp = new int[rowcoins][colamounts];
        
        // Initilaizing base case : for each coin for amount to zero [first column] 
        for(int row = 0; row< rowcoins; row++){
            dp[row][0] = 1; 
        }
        
        // Initilaizing base case : for each amount till given amount [first row]
        for(int col = 1; col< colamounts; col++){
            dp[0][col] = 0; 
        }
        
          
        for(int row = 1; row< rowcoins; row++){
            for(int col = 1; col< colamounts; col++){  
               
                if(coins[row-1]>col){                      // incase coin value is less then current amount
                                                           // choose previous coin value for given amount 
                    dp[row][col] =  dp[row-1][col];
                    continue;
                }
              
                dp[row][col] =  dp[row][col-coins[row-1]] + dp[row-1][col];
                    
           } 
        }
        

        //the numbers wil be in the last element of array
        return dp[rowcoins-1][colamounts-1];
    }
}