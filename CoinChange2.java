/*
 * #518. Coin Change 2
 * 
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 

Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

 */


/*
 * Time Complexity: O (NxM) -> traverse the rows and columns
 * 
 * Space Complexity: O (NxM) -> different number of rows and columns
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP2;

public class CoinChange2 {
	
	public int change(int amount, int[] coins) {
        
		// Create a 2D matrix with 'coins.length+1' rows and 'amount+1' columns
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        /*
         * Fill up the first column with 1
         * The total number of ways required to make amount = 0 with any denomination is 1 -> empty array
         */
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        
        /*
         *  Fill up the first row starting from second column since first is already filled with '1'  
         *  because, total number of combinations/ways required to make any amount from '0' is not possible, so fill with '0'
         */  
        for(int j = 1; j <= amount; j++){
            dp[0][j] = 0;
        }
        
        /*
         * After filling up the first column and row 
         * Traverse through the remaining rows and columns of matrix
         * 
         * Check:
         * 	1. If the amount to make is less than given coin denomination
         * 	   - If yes, meaning we cannot make amount from given coin, but we can make amount from lesser denomination
         * 		 So, copy the value from top of matrix 
         *  2. Else, in other cases, we can make the amount from current and previous denominations
         *     In such cases, we go for choose or don't choose the current denomination
         *     DC:
         *     	- If we don't choose, then copy the total number of ways/combinations from top in matrix
         *     C:
         *     	- If we choose, e.g: from [1,2] make amount = 2
         *     		- then, we can make the amount by choosing higher denomination first (2 in this case)
         *     	      meaning, we need to find the remaining amount to make
         *     		- then we compute the remaining amount by subtracting the higher denomination just used (current coin) from the amount
         *     		- And, get the total number of ways/combination value at index 'j' (remaining amount)
         *     Then, we add both -> C + DC -> to get total number of ways to make amount from given coins
         *     
         * We repeat the steps 1 or 2 until all the values in matrix are filled
         * 
         * After exiting the for loop, we just return the last value in matrix dp[coins.length][amount]
         * because, unlike previous problem, we have filled first row with '0', not infinity
         * So, we don't have to check for edge cases where code will run into error because of infinity 
         * 	
         */
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
    }

}
