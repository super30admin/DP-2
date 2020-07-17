/**
 * Time Complexity : O(n) where n = number of coins
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String args[]){
        int[] myArr = new int[]{1,2,5};
        int amount = 5;
        CoinChange2 obj = new CoinChange2();
        System.out.println(obj.change(amount,myArr));

    }
}