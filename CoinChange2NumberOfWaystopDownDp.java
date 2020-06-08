// no of ways is my output
class Solution {
    public int change(int amount, int[] coins) {
     
      int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i =1;i<dp[0].length;i++ )
        dp[0][i] = 0;
        
        for(int i = 0;i<dp.length;i++){
            dp[i][0]=1;  //this will handle my amount =0 case ie 1 way
        }
        //base
       if(coins == null ) return 0;
        
        
        
        //logic
        
        for(int i = 1;i<dp.length;i++){
            for(int j= 1;j<dp[i].length;j++)
               if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j]; // amount less than denmination missed then line26 choosen has index out of bounds
                }
            else{
                 dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; //not chosen + chosen ways
            }
    }
    return dp[coins.length][amount];

}}

/*
TimeComplexity O(m x n) m is amount and n is no of coins
Space Complexity O(mxn)
*/

/*PRINT DP
/*   int[] coin = {1,2,5};
        amount = 11;
        int dp[][] = new int[coin.length+1][amount+1];
        for(int i =0 ;i<dp.length;i++){
            for(int j = 0;j<dp[i].length;j++){
                System.out.print(dp[i][j]);
            }
        System.out.println();
}*/
