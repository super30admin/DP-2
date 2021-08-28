public class DP {
    // Time Complexity :N
// Space Complexity :N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
    //Problem1(https://leetcode.com/problems/paint-house/)
    public int minCost(int[][] costs) {
      
        if(costs == null || costs.length ==0) return 0;
        int dp[][] = new int[costs.length][3];
        for(int i=0;i<3;i++){
            dp[dp.length-1][i]=costs[costs.length-1][i];
        }
        for(int i=dp.length-2;i>=0;i--){
            dp[i][0]=costs[i][0] +  Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=costs[i][1] +  Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=costs[i][2] +  Math.min(dp[i+1][0],dp[i+1][1]);
        }
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
        
    }
     // Time Complexity :N^2
// Space Complexity :N^2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
    //Problem2 (https://leetcode.com/problems/coin-change-2/)
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length==0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
      
        for(int i=0;i<dp.length;i++){
            dp[i][0]= 1;
        }
        for(int i =1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
        
        
       
       }
       public static void main(String[] args){
            DP dp = new DP();
            int[] coins ={1,2,5};
            dp.change(5, coins);
       }
}
