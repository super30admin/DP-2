time complexity is n*3
    /* Time complexity is n*3
    Space complexity : 3 */

class Solution {

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