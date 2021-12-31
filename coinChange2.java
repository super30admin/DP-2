class Solution {
    public int change(int amount, int[] coins) {


        int [][] dp=new int[coins.length+1][amount+1];
        for(int row=0;row<coins.length+1;row++){
            for(int col=0;col<amount+1;col++){

                if(row==0){
                    if(col==0){
                        dp[row][col]=1;
                    }else{
                        dp[row][col]=0;
                    }

                }else if(col<coins[row-1]){
                    dp[row][col]=dp[row-1][col];

                }
                else{
                    dp[row][col]=dp[row][col-coins[row-1]]+dp[row-1][col];

                }
            }
        }

        return dp[coins.length][amount];





    }
}

