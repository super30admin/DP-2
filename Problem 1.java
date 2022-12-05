// Time Complexity : O (coins * amount)
// Space Complexity :O (coins * amount)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : The generation of 0/base case was difficult


// Your code here along with comments explaining your approach
/*
We need to break down the problem to the smallest problem
At each choice, we will add the number of way when chooseing and when not choosing together 
to come up with a total sum
*/
class Solution {
    public int change(int amount, int[] coins) {

        
        int dp[][] = new int[coins.length+1][amount+1];
        
        // Seeding the value for 0 case, lets assume that for amount 0, we have 1 way
        for(int row=0;row<=coins.length;row++){ 
            dp[row][0] = 1;
        }

        for(int row = 1; row<=coins.length;row++){
            for(int col=1;col<=amount;col++){
                if(col<coins[row-1]){
                    // get zero case

                    dp[row][col] = dp[row-1][col];
                }else{
                    // ways when not choosing plus choosing
                    dp[row][col] = dp[row-1][col] + dp[row][ col - coins[row-1]];
                }
            }
        }

        return dp[coins.length][amount]; // the last row and last column would have the total number of ways

    }
}