// Time Complexity : O(n^2), n is the number of coins and amount
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class CoinChange2 {
    public int change(int amount, int[] coins) {
        // if(coins.length == 0){
        //     return 0;
        // }
        
        
    //     return helper(coins,amount,0,0);
    // }
    
//     private int helper(int[]coins,int amount,int index,int count)
//     {
//         if(amount ==0){
//             return count+1;
//         }
//         if(amount < 0 || index >= coins.length){
//             return 0;
//         }
        
//         //include the coin 
//         int case1 = helper(coins,amount-coins[index],index,count);
//         int case2 = helper(coins,amount,index+1,count);
        
//         return case1+case2;
        
//     }
        if(coins == null){
            return 0;
        }
       
        
    
        int[][]dp = new int[coins.length + 1][amount+1];
        
        
        for(int r = 0;r < dp.length;r++){
            dp[r][0] = 1;
        }
        
        for(int i = 1; i < dp.length;i++){
            for(int j = 1; j < dp[0].length;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}
