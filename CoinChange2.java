public class CoinChange2{
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        //return helper(amount, coins, 0, 0);
       if(coins == null){
           return 0;
       }
       
       int[][]dp = new int[coins.length + 1][amount + 1];
       
       
       for(int i=1; i<dp.length; i++){
           dp[i][0] = 1;
       }
       
       for(int i=1; i<dp.length; i++){
           for(int j=1; j<dp[0].length; j++){
               if(j < coins[i - 1]){
                   dp[i][j] = dp[i-1][j];
               }else{
                   dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
               }
           }
       }
       return dp[dp.length - 1][dp[0].length - 1];
   }
}