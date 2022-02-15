class Solution {


  // space complexity - o(3n)
    	//time - o(3n)
      //Ran on leeetcode successfully : Yes
      // Problem faced  : No
    	//Approach : take a 2d dp array, the value of cell will be equal to sum of cost of painting by the current cell and
      //minimum the cost of painting the house from previous row of different color. 

  public int minCost(int[][] costs) {

    int[][] dp = new int[costs.length][costs[0].length];

    for(int i=0; i<dp.length; i++){

      for(int j=0; j<dp[0].length; j++){
        if(i == 0){
          dp[i][j] = costs[i][j];
        }
        else {
          int min = Integer.MAX_VALUE;
          for(int k = 0 ; k<costs[0].length ; k++){
            if(k != j){
              min = Math.min(min,costs[i][j] + dp[i-1][k]);
            }
          }
          dp[i][j] = min;
        }

      }
    }
    int res = Integer.MAX_VALUE;
    for(int j=0; j<dp[0].length; j++){
        res = Math.min(res,dp[costs.length-1][j]);
    }
    return res;
  }

  // space complexity - o(n)
      	//time - o(n)
        //Ran on leeetcode successfully : Yes
        // Problem faced  : No
      	//Approach : brute force using back tracking 3^n


  public int minCostBF(int[][] costs) {

    int[][] dp = new int[costs.length][cost[0].length];

    for(int i=0; i<dp.length; i++){

      for(int j=0; j<dp[0].length; j++){
        if(i == 0){
          dp[i][j] = costs[i][j];
        }
        else {
          int min = Integer.MIN_VALUE;
          for(int k = 0 ; k<costs[0].length ; k++){
            if(k != j){
              min = Math.min(min,costs[i][j] + dp[i-1][k]);
            }
          }
          dp[i][j] = min;
        }

      }
    }
    return dp[costs.length][costs[0].length];
  }
/********************************************************************************************************************************************/
  // space complexity - o(n)
      	//time - o(n)
        //Ran on leeetcode successfully : Yes
        // Problem faced  : No
      	//Approach : brute force using back tracking 3^n

    int minCost = Integer.MAX_VALUE;

    public int minCostBF(int[][] costs) {
        minCost(costs, 0,-1, 0);
        return minCost;
    }

    public void minCost(int[][] costs, int house, int color, int cost) {
        if(house ==  costs.length){
            minCost  = Math.min(minCost, cost);
            return;
        }

        for(int j=0 ; j< costs[0].length; j++){
            if(j != color){
                minCost(costs, house+1, j ,  cost + costs[house][j]);
            }
        }
    }

}
