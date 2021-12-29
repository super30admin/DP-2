// Time Complexity : O(n * amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int change(int amount, int[] coins) {
//         int result = calculate(amount, coins, 0, 0);
       
//         return result;
//     }
//     private int calculate(int amount, int[] coins, int index){
         
//         if(amount == 0){
//             return 1;
//         }
//         if(amount < 0){
//             return 0;
//         }
//         if(index == coins.length){
//             return 0;
//         }
//         int taken = calculate(amount - coins[index], coins, index);
//         int notTaken = calculate(amount, coins, index+1);
        
//         return taken + notTaken;
//     }
          int[][] dp = new int[coins.length+1][amount+1];
        
        //Initialize first column
        for(int i = 1; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= amount ; i++){
            dp[0][i] = 0;
        }
        for(int row = 1; row <= coins.length; row++){
            for(int column = 1; column <= amount; column++){
                if(coins[row-1] > column){
                    dp[row][column] = dp[row-1][column];
                }
                else{
                    dp[row][column] = dp[row-1][column] + dp[row][column-coins[row-1]];
                }
            }   
        }
       
        return dp[coins.length][amount];
    }
}
