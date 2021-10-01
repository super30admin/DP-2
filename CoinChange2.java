class Solution {
    public int change(int amount, int[] coins) {
        //init
        int row = coins.length+1;
        int col = amount+1;
        
        //metric of dp
        int[][] dp = new int[row][col];
        
        for(int i=1;i<col;i++){ //col
            dp[0][i]=0;
        }
        for(int i=0;i<row;i++){ //row
            dp[i][0]=1;
        }
        
        for(int i=1;i<row;i++) //coins iteration
        {
            for(int j=1;j<col;j++) //amount iteration 0->5
            {
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j]; //take from previous row
                }
                else{
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];//add upper amount and num of steps back
                }
            }
        }
        
        return dp[row-1][col-1];
    }
}

//time: O(n*m) num of coins and num of amount
//space: O(n*m) num of coins and numof amount space use in matrix
//approach : matrix solution for dp 
//ran successfully on leetcode
