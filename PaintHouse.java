// Time Complexity :O(n) total houses
// Space Complexity :O(1)

/*
 * here we use bottom up approach and calculate the min cost at each step and 
 * for each paint. return the minimum of all three paint cost.
 */

public class PaintHouse {
    public int minCost(int[][] costs){
        int n = costs.length;
        int[] dp = new int[3];

        for(int i = 0; i < 3; i++) dp[i] = costs[n-1][i];

        for(int i = n-2; i >= 0; i--){
                int tempR = dp[0];
                dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);
                int tempB = dp[1];
                dp[1] = costs[i][1] + Math.min(tempR, dp[2]);
                dp[2] = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    
    /* // recursive solution
    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0) return 0;
        int costsR = helper(costs, 0, 0, 0);
        int costsB = helper(costs, 0, 0, 1);
        int costsG = helper(costs, 0, 0, 2);
        return Math.min(costsR, Math.min(costsB, costsG));
    }

    public int helper(int[][] costs, int idx, int minCost, int color){
        //base
        if(idx == costs.length) return minCost;

        //logic
        if(color == 0){
            return Math.min(helper(costs, idx+1, minCost + costs[idx][0], 1),
            helper(costs, idx+1, minCost + costs[idx][0], 2));
        }
        if(color == 1){
            return Math.min(helper(costs, idx+1, minCost + costs[idx][1], 0),
            helper(costs, idx+1, minCost + costs[idx][1], 2));
        }
        if(color == 2){
            return Math.min(helper(costs, idx+1, minCost + costs[idx][2], 0),
            helper(costs, idx+1, minCost + costs[idx][2], 1));
        }

        return -1;
    }*/

    public static void main(String[] args) {
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};
        PaintHouse ph = new PaintHouse();
        System.out.println(ph.minCost(costs));
    }
}
