/**
 * iterative
 * 
 * time: 3 * 2 ^ (n-1) => 2^n
 * space: 2^n
 */
class Problem22 {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int caseR = helper(costs, 0, 0, 0);
        int caseB = helper(costs, 0, 1, 0);
        int caseG = helper(costs, 0, 2, 0);

        return Math.min(caseR, Math.min(caseB, caseG));
    }

    public int helper(int[][] costs, int index, int color, int minCost){
        // base
        if(index == costs.length) return minCost; 

        // logic
        if(color == 0){
            return Math.min(
                helper(costs, index+1, 1, minCost + costs[index][0]),
                helper(costs, index+1, 2, minCost + costs[index][0])
            );
        }
        if (color == 1){
            return Math.min(
                helper(costs, index+1, 0, minCost + costs[index][1]),
                helper(costs, index+1, 2, minCost + costs[index][1])
            );
        } 
        if (color == 2) {
            return Math.min(
                helper(costs, index+1, 0, minCost + costs[index][2]),
                helper(costs, index+1, 1, minCost + costs[index][2])
            );
        }
        return 8888;
    }
}

/**
 * DP
 * 
 * m = 3 as there are only 3 colors
 * time: O(n*m) => O(n*3) => O(n)
 * space: O(1)
 */
class Problem22Approach1 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;

        int costR = costs[n-1][0]; 
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];

        for(int i = n-2; i>=0; i--){
            int tempR = costR;
            int tempB = costB;
            costR = costs[i][0] + Math.min(costG, costB);
            costB = costs[i][1] + Math.min(tempR, costG);
            costG = costs[i][2] + Math.min(tempR, tempB); 
        }
        return Math.min(costR, Math.min(costB, costG));
    }
}
