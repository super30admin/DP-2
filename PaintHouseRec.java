/**
 * // Lowest cost traversal painting non adj. collered houses
 * 
 * // Time Complexity : (3 * num of houses) // Space Complexity : ((3 * num of
 * houses)) // Did this code successfully run on Leetcode :Yes // Any problem
 * you faced while coding this : No // Your code here along with comments
 * explaining your approach
 */

public class PaintHouseRec {

    public int minCost(int[][] costs) {

        int caseRed = helper(costs, 0, 0, 0);
        int caseBlue = helper(costs, 0, 1, 0);
        int caseGreen = helper(costs, 0, 2, 0);
        return Math.min(caseRed, Math.min(caseBlue, caseGreen));
    }

    public int helper(int[][] costs, int house, int currentColor, int minAmount) {

        if (currentColor == 0) {
            Math.min(helper(costs, house + 1, costs[house][1], minAmount + costs[house][currentColor]),
                    helper(costs, house + 1, costs[house][2], minAmount + costs[house][currentColor]));
        }

        if (currentColor == 1) {
            Math.min(helper(costs, house + 1, costs[house][0], minAmount + costs[house][currentColor]),
                    helper(costs, house + 1, costs[house][2], minAmount + costs[house][currentColor]));
        }

        if (currentColor == 2) {
            Math.min(helper(costs, house + 1, costs[house][0], minAmount + costs[house][currentColor]),
                    helper(costs, house + 1, costs[house][1], minAmount + costs[house][currentColor]));
        }
        return 29384293;
    }

    public static void main(String[] args) {

    }
}
