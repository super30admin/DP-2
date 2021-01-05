// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not too many problems


// Your code here along with comments explaining your approach

public class Coin_Change_2 {

    public int change(int amount, int[] coins) {

        if(coins == null || coins.length == 0){
            if(amount == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        // if(coins.length == 1){
        //     if(amount == coins[0]){
        //         return 1;
        //     }
        //     else{
        //         return 0;
        //     }
        // }

        int [][] dp = new int[coins.length + 1][amount + 1];

        //fill first column with 1's bc only one way to get to amount with just coin 1
        for(int j = 0; j < dp.length; j++){
            dp[j][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //copies down value from above if coin greater than current amount
                if(coins[i - 1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //add value from above and ways from one coin denomination before
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];

    }


}