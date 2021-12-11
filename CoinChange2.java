// Time Complexity : O(n*amount) where n is the length of coins array
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : No

public class CoinChange2 {

    public int change(int amount, int[] coins) {

        if(coins == null || coins.length ==0) {
            return 0;
        }

        int n = coins.length;

        // Since there are repeated sub-problems, we take dp array to memoize the precomputed values.
        // We have took 1D array, could have taken 2D array as well - but we can optimize the space over here.
        int []dp = new int[amount+1];
        dp[0] =1;

        int j =0;
        // Iterating over the coins array to find how many ways are possible when there are (0th-jth - indices)
        // coins present in the coins array to makeup ith amount if we are at jth index
        while(j< n) {
            for(int i =0; i<=amount; i++) {

                // Checking if we donot run out of bounds
                // If we run, then consider the previous value only
                // example, we have 1,2 coins present, and we want to make 1 amount.
                // we cant make 1 amount using only coin2 because 1-2 = -1 which is negative, hence ignore this.
                if(i-coins[j]>=0){
                    dp[i] = dp[i] + dp[i-coins[j]];
                }
            }
            j++;
        }

        // Our total ways lie at the last index which is dp[amount]
        return dp[amount];
    }
}
