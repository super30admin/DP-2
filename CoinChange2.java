// Time Complexity : O(m*n), where m and n are amount and length of coins respectively.
// Space Complexity : O(m) , m is amount
// Did this code successfully run on Leetcode : Yes
// Approach : We create a matrix with rows as coins and columns as amount starting from 0. The zeroth row will have 0 values except
// [0,0] because the amount is not possible to get with 0 coins. We iterate and find the values of the matrix with a logic and the last value of
// the matrix gives the solution to get number of ways. I have used a single dimensional array to reduce the space complexity.

// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 1; i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j >= coins[i-1]){ //update the array values only after amount is greater than or equals coin value
                    dp[j] = dp[j] + dp[j-coins[i-1]]; //logic to add the previous row element with number of steps back in the same row.
                }
            }
        }

        return dp[amount];
    }
}