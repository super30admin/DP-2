/**
 * Time complexity is 2^n - n is number of houses
 * no addition variables allocated but size of the stack is exponential because of the exponential recursive calls
 * 
 * time limit exceeds on leetcode.
 */
class Solution {
    public int minCost(int[][] costs) {
        
        int costR = helper(costs, 0, 0, 0);
        int costG = helper(costs, 0, 1, 0);
        int costB = helper(costs, 0, 2, 0);
        
        return Math.min(costR, Math.min(costG, costB));
    }
    
    private int helper(int[][] costs, int index, int color, int min) {
        if(index >=costs.length) {
            return min;
        }
        if(color == 0) {
            return Math.min(helper(costs, index+1, 1, min + costs[index][0]),
                            helper(costs, index+1, 2, min + costs[index][0]));
        }
        if(color == 1) {
            return Math.min(helper(costs, index+1, 0, min + costs[index][1]),
                            helper(costs, index+1, 2, min + costs[index][1]));
        }
        return Math.min(helper(costs, index+1, 0, min + costs[index][2]),
                        helper(costs, index+1, 1, min + costs[index][2]));
    }
}