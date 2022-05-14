/**
 * Greedy
 * 
 * Approach:
 * Greedy solution will fail as it believes that local optima always leads to global optima
 * Greedy Approach will choose the least amongst each row
 * Problem: We cannot just choose the least among each row and then go to the next
 * because the next row may have bigger alternate values
 * 
 *  R    B   G
 *  17   2   17   ==> if we choose blue in this case being the least cost 2
 * 800   5   200    => then we wont be able to choose blue again which had 5
 * 
 * Thus, greedy will fail for this case
 */

/**
 * https://leetcode.com/problems/paint-house/
 * iterative
 * 
 * time: 3 * 2 ^ (n-1) => 2^n
 * space: 2^n -- recursive stack space 
 * 
 * 17   2   17
 * 16   6   5
 * 14   3   19
 * 8    20  18
 * 
 * Approach:
 * 1. if we start by choosing RED, from the next row we can only choose
 *      the minCost between BLUE, GREEN
 * 2. if we start by choosing BLUE, from the next row we can only choose
 *      the minCost between RED, GREEN
 * 3. if we start by choosing GREEN, from the next row we can only choose
 *      the minCost between RED, BLUE
 * 4. Finally take the min between all the 3 cases
 * 
 * 1. If the RED is choosen then 
 *      take the minimum cost returned from each of the two cases not Choose choose
 *          (bottom base case)
 * 
 *     for the recursive function for both bases pass the params:
 *      the costs array as is
 *      increment the index for the next row
 *      pass the respective color           (if RED was choosen then min(BLUE, GREEN))
 *      add its cost to the minCost         (if RED was choosen then add the cost corresponding to RED)
 *              
 *              R
 *             17
 *        B /     \ G
 *        6         5
 *       /  \      /  \
 *      14  19    14   3
 * 
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
 * 
 * Approach:
 * 0. Initially store the last row cost in 3 color variables
 * 0. Start from 2nd last row
 *    and add 
 * 1. the cost of selecting color from the 2nd last row
 *      +
 * 2. the min between other two colors from the last row
 * 
 * 
 * keep decrementing the row and repeat
 * keep overwriting the total cost at each color variable
 * in the for loop ensure to have a temp variable as we are overwriting the color variables
 * 
 */
class Problem22Approach1 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        
        // init with last row cost
        int costR = costs[n-1][0]; 
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];

        // bottom up
        for(int i = n-2; i>=0; i--){ // start from 2nd last row
            int tempR = costR;
            int tempB = costB;
            costR = costs[i][0] + Math.min(costG, costB);
            costB = costs[i][1] + Math.min(tempR, costG);
            costG = costs[i][2] + Math.min(tempR, tempB); 
        }
        return Math.min(costR, Math.min(costB, costG));
    }
}
