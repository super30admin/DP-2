// TC - O(3*2^N)
// SC - O(3*2^N)

// Constraints:
//     costs.length == n
//     costs[i].length == 3
//     1 <= n <= 100
//     1 <= costs[i][j] <= 20


public class PaintHouseRecursion {
    class Solution {
        public int minCost(int[][] costs) {
            int costFirstHouseRed = helper(costs, 0, 0, 0);
            int costFirstHouseGreen = helper(costs, 0, 1, 0);
            int costFirstHouseBlue = helper(costs, 0, 2, 0);

            return Math.min(costFirstHouseGreen, Math.min(costFirstHouseRed, costFirstHouseBlue));
        }

        private int helper(int[][] costs, int house, int color, int cost) {
            if (house >= costs.length) {
                return cost;
            }
            if (color == 0) {
                int costGreen = helper(costs, house + 1, 1, cost + costs[house][color]);
                int costBlue = helper(costs, house + 1, 2, cost + costs[house][color]);
                return Math.min(costGreen, costBlue);
            } else if (color == 1) {
                int costRed = helper(costs, house + 1, 0, cost + costs[house][color]);
                int costBlue = helper(costs, house + 1, 2, cost + costs[house][color]);
                return Math.min(costRed, costBlue);
            } else {
                int costRed = helper(costs, house + 1, 0, cost + costs[house][color]);
                int costGreen = helper(costs, house + 1, 1, cost + costs[house][color]);
                return Math.min(costRed, costGreen);
            }
        }
    }
}
