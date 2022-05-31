public class coinChang2 {

    private static int exhaustiveApproach(int[] coins, int coinIndex, int amount){

        //base conditions
        if(amount == 0) return 1;
        //if path leads to no result or we have decided not to choose all the coinds
        if(amount < 0 || coinIndex < 0) return 0;

        //logic
        int case1 = exhaustiveApproach(coins, coinIndex, amount-coins[coinIndex]);
        //case2 : not choose a coin
        int case2 = exhaustiveApproach(coins, coinIndex -1, amount);
        return case1 + case2;
    }

    private static int dpApproach(int[] coins, int amount){
        int[][] dp = new int[coins.length+1][amount+1];
        //make 1st column value as 1
        for(int i = 0; i< dp.length; i++)
            dp[i][0] = 1;

        for(int i = 1; i< dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                //case 1 : amt <  coin value
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        System.out.println("Number of combinations : "+ exhaustiveApproach(new int[]{1,2,5}, 0, 5));
        System.out.println("Number of combinations : "+ dpApproach(new int[]{1,2,5},5));
    }

}