//Time Complexity: O(n^2)
//Space Complexity: O(n)


public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount =5;

        int result = numberOfCombination(coins,amount);
        System.out.println("Number of Combination that make amount: "+result);
    }
    private static int numberOfCombination(int[] coins, int amount){

        int[] dp = new int[amount+1];
        for(int i=1;i<=coins.length;i++){
            dp[0]=1;
            for(int j=1;j<=amount;j++){

                if(j>=coins[i-1]){
                    dp[j] = dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
