// TC - O(3N)
// SC - O(3N)

// Constraints:
//     costs.length == n
//     costs[i].length == 3
//     1 <= n <= 100
//     1 <= costs[i][j] <= 20

public class PaintHouseDP {
    class Solution {
        public int minCost(int[][] costs) {
            int houseCount = costs.length;
            int colorCount = costs[0].length;
            int[][] houseToColorCostMatrix = new int[houseCount][colorCount];
            for (int j = 0; j < colorCount; j++) {
                houseToColorCostMatrix[houseCount - 1][j] = costs[houseCount - 1][j];
            }

            for (int i = houseCount - 2; i >= 0; i--) {
                houseToColorCostMatrix[i][0] = costs[i][0]
                        + Math.min(houseToColorCostMatrix[i + 1][1], houseToColorCostMatrix[i + 1][2]);
                houseToColorCostMatrix[i][1] = costs[i][1]
                        + Math.min(houseToColorCostMatrix[i + 1][0], houseToColorCostMatrix[i + 1][2]);
                houseToColorCostMatrix[i][2] = costs[i][2]
                        + Math.min(houseToColorCostMatrix[i + 1][0], houseToColorCostMatrix[i + 1][1]);
            }

            return Math.min(houseToColorCostMatrix[0][0],
                    Math.min(houseToColorCostMatrix[0][1], houseToColorCostMatrix[0][2]));
        }
    }
}
