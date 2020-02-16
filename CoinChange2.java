// Recursive method
// Time Complexity : O(m*2^n); n -> no. of houses, m -> amount
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes, Time limit Exceeded due to recursive approach
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * The logic for choosing a coin or not choosing a coin is similar to the base problem of coin change. The difference in this case is that 
 * we need to keep track of all the possible combinations of denominations resulting in the given amount. 
 * Hence in the base case the count is being increased whenever an amount of 0 is observed. This means that the combination of denominations
 * in the given path has successfully formed the amount.
 * The main logic evaluated the counts by considering the coin at a given index as well as by not considering the coin at a given index. 
 */

class CoinChange2 {
    public int change(int amount, int[] coins) {
        //edge case
        if(coins == null) {
            return 0;
        }
        return helper(coins, 0, 0, amount);
    }
    
    private int helper(int[] coins, int index, int count, int amount) {
        //base case
        if(amount == 0) {
            count++;
            return count;
        }
        if(amount < 0) {
            return 0;
        }
        if(index > coins.length-1) {
            return count;
        }
        
        //logic
        //choose a coin
        int count1 = helper(coins, index, count, amount-coins[index]);
        //do not choose a coin
        int count2 = helper(coins, index+1, count, amount);
        return count1+count2;
    }
}

//Tabulation method
//Time Complexity : O(m*n); m -> amount; n -> no. of coins
//Space Complexity : O(m*n)
//Did this code successfully run on Leetcode : Yes  
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
/*
* As part of recursive solution, it was observed that there are two parameters which may change: the amount and the index. 
* Therefore, we need to consider a 2 dimension array for tabulation. 
* The length of rows will be coins.length +1 to help considering the scenario when the given amount cannot me made.
* The length of columns will be amount +1, for considering the scenario when 0 amount is made.
* While iterating, we will take the total no. of ways of forming amount from previous iteration + total no. of ways it can be formed in the
* current iteration.
*/ 

class CoinChange2DP {
    public int change(int amount, int[] coins) {
        //edge case
        if(coins == null) {
            return 0;
        }
        //return helper(coins, 0, 0, amount);
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < coins.length+1; i++) {
            dp[i][0] = 1; //1 way of forming the amount 0: by not choosing the coins.
        }
        for(int i = 1; i < coins.length+1; i++) {
            for(int j = 0; j < amount+1; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j]; // when amount is less than the current denomination
                }
                else dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; // ways of forming the amount in previous step + current step
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}