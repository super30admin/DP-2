// Time Complexity : 0(amount*coins)
// Space Complexity : 0(amount*coins)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution{

    public int coinchange2(int amount, int[] coins){

        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
        for(int i = coin; i <= amount; i++){

            dp[i] += dp[i - coin];  // here we add total no of ways for two cases - one for when coin is considered and other when the particular coin is not considered
            }
        }

        return dp[amount]; // return the final number of ways to get the total amount required as mentioned in the problem
    }

    }