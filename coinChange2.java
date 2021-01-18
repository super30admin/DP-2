//Time Complexity  : o(m*n)
 // Space Complexity : o(m*n) .. 
public class coinChange2 {

    public static void main(String args[]) {
                int coins[]= new int[] {1,2,5};
                int amount  = 5;
                System.out.println(coinChangeProblem(coins,amount));
            }


        public static int coinChangeProblem(int coins[],int amount) {


            if((coins==null ||coins.length==0) && amount == 0)
                return 1;

            if((coins==null ||coins.length==0) && amount != 0)
                return 0;

            int dp[][] = new int[coins.length+1][amount+1];

            for(int i=1;i<amount+1;i++){
                dp[0][i] = 0;
            }

            for(int i=0;i<coins.length+1;i++){
                dp[i][0] = 1;
            }

            for(int i=1;i<=coins.length;i++){
                for(int j=1;j<=amount;j++){
                    if(j<coins[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    }
                }
            }

            return dp[coins.length][amount];
        }
}