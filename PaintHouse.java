class PaintHouse {
    // exhaustive recursive: Time Limit Exceeded
    // time complexity is 2^n as no of columns are constant
    //space complexity : n-> total number of recursive calls
     public int minCostRecursion(int[][] costs) {
         int minCost = Integer.MAX_VALUE;

         for(int index = 0; index < costs[0].length; index++) {
             minCost = Math.min(minCost, helper(costs, 0, index, 0));
         }

         return minCost;
     }

     private int helper(int[][] costs, int row, int col, int minCost) {

         if(row == costs.length){
             return minCost;
         }

         //logic
         int minCostCurrent = Integer.MAX_VALUE;

         for(int color = 0; color < costs[0].length; color++){
             if(color == col) {
                 continue;
             }
             minCostCurrent = Math.min(minCostCurrent, helper(costs, row + 1, color, minCost + costs[row][col]));
         }

         return minCostCurrent;
     }
     // DP bottom up tabulation
     // time complexity is n*3
     //space complexity : n*3
     public int minCostDpTabulation(int[][] costs) {
         int[][] dp = new int[costs.length][costs[0].length];
         for(int index = 0; index < costs[0].length; index++) {
             dp[costs.length - 1][index] = costs[costs.length - 1][index];
         }

         for(int row = costs.length - 2; row >= 0; row--) {

             for(int col = 0 ; col< costs[0].length; col++) {
                 int currMin = Integer.MAX_VALUE;
                 for(int color = 0; color < costs[0].length; color++) {
                     if(col == color) {
                         continue;
                     }
                     currMin = Math.min(currMin, dp[row + 1][color]);
                 }
                 dp[row][col]= costs[row][col] + currMin;
             }
         }

         int minCost = Integer.MAX_VALUE;
         for(int index = 0; index < costs[0].length; index++){
             minCost = Math.min(minCost, dp[0][index]);
         }

         return minCost;
     }

    // DP bottom up tabulation space optimized
    // time complexity is n*3
    //space complexity : 3
    public int minCost(int[][] costs) {
        int[] dp = new int[3];
        for(int index = 0; index < 3; index++) {
            dp[index] = costs[costs.length - 1][index];
        }

        for(int row = costs.length - 2; row >= 0; row--) {
            int temp0 = dp[0];
            int temp1 = dp[1];
            int min = 0;
            for(int col = 0 ; col< 3; col++) {
                if(col == 0){
                    min = Math.min(temp1, dp[2]);
                }
                if(col == 1) {
                    min = Math.min(temp0, dp[2]);
                }

                if(col == 2) {
                    min = Math.min(temp0, temp1);
                }
                dp[col] = costs[row][col] + min;
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(int index = 0; index < costs[0].length; index++){
            minCost = Math.min(minCost, dp[index]);
        }

        return minCost;
    }
}