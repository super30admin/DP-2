
// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        
        //base case
        if(coins == null || coins.length == 0){
            return 0;
        }

        //create a new 2D array
        int[][] dp = new int[coins.length + 1][amount + 1];

        //set the dummy column 0
        for (int i = 0; i < coins.length + 1; i ++){
            dp[i][0] = 1;
        }

        //start at position 1,1 in 2D array
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){

                //when amount is less than current coin then no way is possible to make a change, 
                //so we simply copy the result of the previous row same column
                //E.g. coins [1, 2] amount 1, current coin 2, since 1(amount) < 2(coin) so the result would be number of ways to get 1(amount) with 1(coin).
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
                }

            }
        }

        return dp[coins.length][amount];

    }
}