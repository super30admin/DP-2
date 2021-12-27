class Solution{
    public int change(int coins, int[] amount){
        if(coins == null || coins.length == 0) return 0; //if there are no coins, we simply return 0;
        int[][] dp = new int[coins.length+1][amount+1]; //we take a 2d array with name dp and we declare their lengths to +1 of coins and amounts length so that it can hold the 0th case.
        for(int j = 0; j < coins.length; j++) { // we go through the 1st column in every row
            dp[j][0] = 1; // we initialize the value to 1. because for amount 0, we are not choosing any coins as 0 by itself is coonsidered a way for forming ana amount 0. so we are initializing it to 1.
        }
        for(int i = 1; i < coins.length; i++){ // we are going through each and every element in the array.
            for(int j = 1; j < amount.length; j++){ //we are going through each and every element in the column.
                if(j < coins[i-1]){ // if the amount present in j is less than the value of coin at i-1
                    dp[i][j] = dp[i-1][j]; // this is the zero case where we take the value present at i-1 to the current i
                }
                else{
                        dp[i][j] = d[i-1][j] + dp[i][j-1]; // this is the one case where we have to add the value of dp[i-1][j-coins[i-1]] to dp[i-1][j]
                }
            }
        }
        return dp[coins.length][amount];
    }
}