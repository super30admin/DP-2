/*
 * Approach 1: Exhaustive
 * Returning the minmum cost of ColorA, ColorB, ColorC
 * 
 * Time Complexity: We are choosing either of the houses to paint and given 3 colors.
 *                      O(N) = O(2^n * 3) : n = Number of Houses.
 */


class PaintHouse {
    public int minCost(int[][] costs) {
        int colorA = helper(costs, 0, 0, 0);
        int colorB = helper(costs, 0, 0, 1);
        int colorC = helper(costs, 0, 0, 2);

        return Math.min(colorA, Math.min(colorB, colorC));
    }

    private int helper(int[][] costs, int i, int cost, int color){
        if(i == costs.length)
            return cost;

        if(color == 0){
            return Math.min(  
                    helper(costs, i+1, cost + costs[i][0], 1),
                    helper(costs, i+1, cost + costs[i][0], 2)
                    );
                }
        else if(color == 1){
            return Math.min(
                    helper(costs, i+1, cost + costs[i][1], 0),
                    helper(costs, i+1, cost + costs[i][1], 2)
                    );
                }   
        else if(color == 2){
            return Math.min(
                    helper(costs, i+1, cost + costs[i][2], 0),
                    helper(costs, i+1, cost + costs[i][2], 1)
                    );
                }   
        return -1;
        }
    }


/*
 * Dynamic Programming
 * We create a seperate matrix to keep track of the minimum costs.
 * Time Complexity: O(m*n): We are iterating all the elememts.
 * Space Complexity = O(m*n) Created a new dp matrix;
 */
class PaintHouse {
        public int minCost(int[][] costs) {
            int m = costs.length;
            int n = costs[0].length;
    
            int [][] dp = new int[m][n];
    
            dp[m-1][0] = costs[m-1][0];
            dp[m-1][1] = costs[m-1][1];
            dp[m-1][2] = costs[m-1][2];
    
            for(int i= m-2; i>=0; i--){
                dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
                dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
            }
            return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
        }
    }


class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int [][] dp = new int [m][n];

        dp[0][0] = costs[0][0]; 
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i=1; i<m; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[m-1][0], Math.min(dp[m-1][1], dp[m-1][2]));
    }
}