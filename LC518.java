// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int change(int amount, int[] coins) {
        
        //initialize a matrix to store all the values for operations
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        //to fill out 1's for the first column
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        
        //to fill out the 0's for the first row
        for(int j = 1; j <= amount; j++){
            dp[0][j] = 0;
        }
        
        //now we start adding values to the matrix
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                //if the current index j is less than the coin on which we are currently, then just copy paste the value from right above
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //else we add the dont_choose way + the choose way by going back in the same row to fetch the value
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}