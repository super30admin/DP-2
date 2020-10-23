// Time Complexity : n*k
// Space Complexity :n*k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        // Edge cases
        if(coins == null){
            return -1;
        }

        // create 2d arrar since there are 2 variables
        int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i=0; i< coins.length+1;i++){
            dp[i][0] = 1;
        }
        //insert value based on number of ways. 
        for(int i=1; i< coins.length+1;i++){
            for( int j=1; j<amount+1;j++){
                if(j < coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        for( int i=0; i<coins.length+1; i++){
            for(int j=0; j<amount+1;j++){
                 System.out.print(dp[i][j]+ " ");
                }
            System.out.println();
            }
        int res = dp[coins.length][amount];
        // if(res==1){
        //     return -1;
        // }
        return res;   
    }
}