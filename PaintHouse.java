public class PaintHouse {
    
  /*  public int minCost(int[][] costs){
        int choiceR = helper(costs, 0, 0, 0);
        int choiceB = helper(costs, 0, 1, 0);
        int choiceG = helper(costs, 0, 2, 0);

        return Math.min(choiceR,Math.min(choiceB,choiceG));
    }

    private int helper(int[][] costs ,int row,int color,int totalAmt){
        //base case
        if(row == costs.length) return totalAmt;
        //choose color
        if(color == 0){
            Math.min(helper(costs,row+1,1,totalAmt+costs[row][color]),
                helper(costs,row+1,2,totalAmt+costs[row][color]));
        }
        if(color == 1){
             Math.min(helper(costs,row+1,0,totalAmt+costs[row][color]),
                helper(costs,row+1,2,totalAmt+costs[row][color]));
        }
        if(color == 2){
             Math.min(helper(costs,row+1,0,totalAmt+costs[row][color]),
                helper(costs,row+1,1,totalAmt+costs[row][color]));
        }
        return Integer.MAX_VALUE;*/


         public int minCost(int[][] costs){
            if(costs == null || costs.length == 0) return 0; 
            int m = costs.length;
            int n = costs[0].length;
            int[] dp = new int[n];
            
            for(int i =0;i<n;i++)
                dp[i]= costs[m-1][i];
            
            for(int i = m-2;i>=0;i--){
                //for(j=0;j<n;j++)
                int tempR= dp[0],tempB=dp[1];
                dp[0] = Math.min(tempB,dp[2])+costs[i][0];
                 dp[1] = Math.min(tempR,dp[2])+costs[i][1];
                  dp[2] = Math.min(tempB,tempR)+costs[i][2];

            }

             return Math.min(dp[0],Math.min(dp[1],dp[2]));
         }

}
