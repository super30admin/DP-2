// TC - O(N)
// SC - O(1)

// Constraints:
//     costs.length == n
//     costs[i].length == 3
//     1 <= n <= 100
//     1 <= costs[i][j] <= 20

public class PaintHouseDPVariables {
    class Solution {
        public int minCost(int[][] costs) {
            int houseCount = costs.length;
            int redCost = costs[houseCount - 1][0];
            int greenCost = costs[houseCount - 1][1];
            int blueCost = costs[houseCount - 1][2];

            for (int i = houseCount - 2; i >= 0; i--) {
                int tempRedCost = redCost;
                int tempGreenCost = greenCost;
                redCost = costs[i][0] + Math.min(greenCost, blueCost);
                greenCost = costs[i][1] + Math.min(tempRedCost, blueCost);
                blueCost = costs[i][2] + Math.min(tempRedCost, tempGreenCost);
            }
            return Math.min(redCost, Math.min(greenCost, blueCost));
        }
    }
}
