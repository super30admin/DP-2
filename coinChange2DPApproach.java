class coinChange2DPApproach {
    //DP appraoch
    //TC will be O(coins.length * amount) as we are iterating over the 2D array of coins.length * amount.
    //SC will be O(coins.length * amount) as we are storing in 2D array of coins.length * amount
    public int change(int amount, int[] coins) {
        if (coins==null || coins.length==0){        //Cond to check if array is empty
            return 0;                               //Return 0, no ways with empty array.
        }

        int[][] dp= new int[coins.length+1][amount+1];    //Declaring 2D array as coins as row and amount as column.
        for(int i=0; i<coins.length+1 ;i++){       //Condn to update the amount in 0 row.
            dp[i][0]=1;                   //Update the value in column 0 as 1, as there is always one way to get amount 0 by not choosing it.
        }

        for(int i=1;i<coins.length+1;i++){     //to iterate over the 2D array row wise
            for(int j=1;j<amount+1;j++){        //to iterate over the 2D array column wise.
                if(coins[i-1]>j){      //Cond to check if the amount is greater than coin at the index then there will be no 1 case and there will be only 0 case
                    dp[i][j]=dp[i-1][j];        //Update the array with 0 case which lies on the upper row.
                }
                else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }


    public static void main(String[] args){
        coinChange2DPApproach obj= new coinChange2DPApproach();
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(obj.change(amount,coins));
    }
}