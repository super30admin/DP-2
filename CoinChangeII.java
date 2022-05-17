//time complexity: O(n*m), m is the amount
//space complexity: O(n*m), m is the amount
public class CoinChangeII {
    public int CoinChangee(int[] coins,int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        if (coins == null) return 0;
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }

        for(int i =1; i< dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] =dp[i-1][j];

                }
                else{
                    dp[i][j] =dp[i-1][j]+dp[i][j-coins[i-1]];

                }
            }
        }
    return dp[coins.length][amount];
    }
    public static void main(String args[]){
        CoinChangeII obj = new CoinChangeII();
        System.out.println(obj.CoinChangee(new int[]{1,2,5},11));
    }
}
