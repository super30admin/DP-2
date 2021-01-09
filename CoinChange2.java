
public class CoinChange2 {
	//Recursion approach
    /*public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        return helper(coins, amount , 0);
    }
    
    private int helper(int[] coins, int amount, int index){
        //base
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;
        //logic
        //when coin is chosen
        int case1 = helper(coins, amount - coins[index], index);
        //when coin isn't chosen
        int case2 = helper(coins, amount, index + 1);
        
        return case1 + case2;
    }
    */
    
    public static int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i= 0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<dp.length;i++){
            for(int j = 1; j<dp[0].length;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length-1];
    }
    
    public static void main(String[] args) {
    	int amount = 11;
    	int[] coins = {1,2,5};
    	System.out.println(CoinChange2.change(amount, coins));
	}
    
}
