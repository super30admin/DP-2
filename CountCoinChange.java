class CountCoinChange {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        //fill 1st column as 1
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }         

        //calc dp array
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){

                //copy from top
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //compare and calc
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }

                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

                
        }

        



        return dp[dp.length-1][dp[0].length-1];   
    }
    public static void main(String[] args){
        System.out.println("Count Coin Change");
        CountCoinChange obj = new CountCoinChange();
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(obj.change(amount, coins));
    }
}