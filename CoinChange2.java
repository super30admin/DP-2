/*
Description: After identifying repeated sub problem in recursive approach, we narrow down to dynamic programming.
using a 2d matrix we fill the matrix accordingly with corresponding sum of number of posssible combinations. as a result
the last element calculated will be our maximum nnumebr of combinations that yield the target value.
Time Complexity: O(n^2) - usage of a nested for loop.
Space Complexity: O(n^2) - usage of a 2d matrix
*/
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null) return 0;
        int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]>j){
                    //zero case
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
