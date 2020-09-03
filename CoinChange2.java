// Time Complexity : O(n*m), n is the number of coins and m is the amount
// Space Complexity : o(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        //initialze 1 for all denominations for amount 0 
        for(int i=0;i<=coins.length;i++){
            dp[i][0] = 1;
        }
        //initilize 0 for 0 denomination for all amount
        for(int j=1;j<=amount;j++){
            dp[0][j]= 0;
        }
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
            	//if the amount is less than the denomination, then copy the previous denominations values
                if(j<coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }else{ //else it will the of the previous denomination value and no:of ways for the difference between the current amount and current denomination.
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
        
    }
}