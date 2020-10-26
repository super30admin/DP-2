package S30.DP_2;

/*DP Solution
Time Complexity : Put: O(mn),  m is costs.length, n is costs[0].length
Space Complexity : O(mn),  m is costs.length, n is costs[0].length

Recursive Solution
Time Complexity: 3 * O(2^n)
Space Complexity: O(n)

Space Efficient Solution
Space complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class PaintHouse {

    public int paintHouseRecursive(int[][] costs){

        if(costs == null || costs.length == 0) return 0;

        int case0 = calculateCosts(costs, 1, 0,costs[0][0]);
        int case1 = calculateCosts(costs, 1, 1,costs[0][1]);
        int case2 = calculateCosts(costs, 1, 2,costs[0][2]);

        return Math.min(case0, Math.min(case1,case2));

    }

    private int calculateCosts(int[][] costs, int row, int lastColor, int min){

        if(row == costs.length){
            return min;
        }

        int case0 = Integer.MAX_VALUE;
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;

        if(lastColor == 0){
            case1 = calculateCosts(costs,row+1,1,min + costs[row][1]);
            case2 = calculateCosts(costs,row+1,2,min + costs[row][2]);
        }
        if(lastColor == 1){
            case0 = calculateCosts(costs,row+1,0,min + costs[row][0]);
            case2 = calculateCosts(costs,row+1,2,min + costs[row][2]);
        }
        if(lastColor == 2){
            case0 = calculateCosts(costs,row+1,0,min + costs[row][0]);
            case1 = calculateCosts(costs,row+1,1,min + costs[row][1]);

        }

        return Math.min(case0, Math.min(case1, case2));

    }

    public int paintHouseDP(int[][] costs){

        if(costs == null || costs.length == 0) return 0;

        int[][] dp = new int[costs.length][3];
        int m = dp.length;
        int n = dp[0].length;

        for(int j = 0; j < n; j++){
            dp[0][j] = costs[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){

                int min = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(j == k) continue;
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = costs[i][j] + min;
            }
        }

        int result = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            result = Math.min(result,dp[m-1][j]);
        }

        return result;

    }

    public int paintHouseUsingInputArray(int[][] costs){
        if(costs == null || costs.length == 0) return 0;
        int m = costs.length;
        int n = costs[0].length;

        for(int i = 1; i < m; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }

        int result = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            result = Math.min(result,costs[m-1][j]);
        }

        return result;

    }

    public int paintHouseSpaceEfficientSolution(int[][] costs){

        if(costs == null || costs.length == 0) return 0;
        int m = costs.length;
        int n = costs[0].length;

        int cost0 = costs[0][0];
        int cost1 = costs[0][1];
        int cost2 = costs[0][2];

        for(int i = 1; i < m; i++){
            int temp0 = cost0;
            int temp1 = cost1;
            cost0 = costs[i][0] +  Math.min(cost1,cost2);
            cost1 = costs[i][1] + Math.min(temp0,cost2);
            cost2 = costs[i][2] + Math.min(temp0,temp1);
        }

        return Math.min(cost0, Math.min(cost1,cost2));

    }

}
