/*TC - O(2^N)
 *SC - Not sure, may be the maximum depth of the recursion tree used 

 Ran on Leetcode - Ran for standard test cases; however, TLE on someinputs since the algorithm uses exponential time complexity 
 * */




class Solution {
    public int change(int amount, int[] coins) {
        // helper ()
        
        return helper(coins, amount, 0);
    }
    
    
    //
    public int helper(int [] coins, int amount, int index){
        // base case
        if (amount == 0 ){
            return 1;
        }
        if (amount < 0 || index == coins.length) return 0 ; 
        // logic
        //not choosing the coin
        int case1 = helper(coins, amount-coins[index], index);
        //choosing the coin
        int case2 = helper(coins, amount, index+1);
            
            
        return case1+ case2;
        
        
    }
    
}


/*DP way  - 
 * TC - O(M*N)
 * SC  -  O(M*N)
 *Ran on leetcode - yes
 * */


class Solution {
    public int change(int amount, int[] coins) {
        // DP way -
        int [][] dp = new int[coins.length+1][amount+1];
        // additional  row of zeroes
        for (int i = 0 ; i < dp.length; i++){
            // number of ways the amount can be zero with zero number of coins
            dp[i][0] = 1;
        }
        for(int i = 1 ; i<dp.length; i++){
            for(int j = 1 ; j < dp[0].length; j++){
            // if denomination of coin is greater than the amount, use theearlier number of ways
                if (j < coins[i-1]) {
                    // zero case
                    dp[i][j] = dp[i-1][j];
                } else {
                    // zero and one
                    dp[i][j] =  dp[i-1][j] + dp[i][j-coins[i-1]]; // move the number of coin denomination back to find the number of ways the amount was acheived without the current coin
                }



            }
        }
        return  dp[dp.length-1][dp[0].length-1];
    }



}

