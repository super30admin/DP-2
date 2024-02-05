// TC - O(N)
// SC - O(3N)

// Constraints:
//     costs.length == n
//     costs[i].length == 3
//     1 <= n <= 100
//     1 <= costs[i][j] <= 20

public class PaintHouseGetColor {
    public int minCost(int[][] costs) {
        int colorIndexFirstHouse = -1;
        int houseCount = costs.length;
        int colorCount = costs[0].length;
        int[][] nextHouseColorMatrix = new int[houseCount][colorCount];

        int redCost = costs[houseCount - 1][0];
        int greenCost = costs[houseCount - 1][1];
        int blueCost = costs[houseCount - 1][2];

        for (int i = houseCount - 2; i >= 0; i--) {
            int tempRedCost = redCost;
            int tempGreenCost = greenCost;
            int tempMinCost = Integer.MAX_VALUE;

            if (greenCost < blueCost) {
                tempMinCost = greenCost;
                nextHouseColorMatrix[i][0] = 1;
            } else {
                tempMinCost = blueCost;
                nextHouseColorMatrix[i][0] = 2;
            }
            redCost = costs[i][0] + tempMinCost;

            if (tempRedCost < blueCost) {
                tempMinCost = tempRedCost;
                nextHouseColorMatrix[i][1] = 0;
            } else {
                tempMinCost = blueCost;
                nextHouseColorMatrix[i][1] = 2;
            }
            greenCost = costs[i][1] + tempMinCost;

            if (tempRedCost < tempGreenCost) {
                tempMinCost = tempRedCost;
                nextHouseColorMatrix[i][2] = 0;
            } else {
                tempMinCost = tempGreenCost;
                nextHouseColorMatrix[i][2] = 1;
            }
            blueCost = costs[i][2] + tempMinCost;
        }

        if (greenCost <= blueCost) {
            if (greenCost <= redCost) {
                colorIndexFirstHouse = 1;
            }
        } else if (blueCost <= redCost) {
            colorIndexFirstHouse = 2;
        } else {
            colorIndexFirstHouse = 0;
        }

        int j = colorIndexFirstHouse;
        for (int i = 0; i < houseCount; i++) {
            System.out.println("House " + i + " : " + j);
            j = nextHouseColorMatrix[i][j];
        }

        return Math.min(redCost, Math.min(greenCost, blueCost));
    }
    public static void main(String[] args) {
        PaintHouseGetColor solution = new PaintHouseGetColor();
        solution.minCost(new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } });
    }
}
