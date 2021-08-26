// Time Complexity: O(number of coins * amount) as we are checking each possible amount value upto target amount with each denomination coin.
// Space complexity: O(number of coins * amount) a matrix is created to reach the final output
// Did you complete problem at leet code: Yes
// Any problems faced: Didn't identify base case of amount 0 if none of the coins is chosen then there is only 1 possibility of getting 0.

//explain your code here
// Idea here is to solve the subproblem reaching upto target amount. first we can calculate
// what is the possibility of achieving amount 1 with each coin denomination there is only 1 possibility using coin of denomination 1.
// further we can calculate for each amount by adding the count of possibilities from previous denomination and subproblem of previous amount solved with current denomination.
// if we have a coin which is equal to target, that says that single coin is also a possibility, in that case we add 1 to number of calculated possibilities
// sum of above will give us the count of possible result
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0) return 0;
        if(amount==0) return 1;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } if(coins[i-1]<j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } 
                if(coins[i-1]==j) {
                    dp[i][j] = 1+dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}