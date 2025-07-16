//Time Complexity: O(2^n) - For each house, we make 2 recursive calls (excluding the previous color), leading to exponential time in the number of houses n.
//Space Complexity: O(n) - Due to the maximum depth of the recursion stack (one level per house).

//Start painting the first house with each of the 3 colors and recursively paint the remaining houses without repeating the previous color.
//At each step, add the cost of the chosen color and move to the next house, branching into two possible color choices.
//Return the minimum total cost among the three starting color options.


class Solution {
    public int minCost(int[][] costMatrix) { // 0 - Red, 1 - Blue, 2 - Green
        int costRed = paintHelper(costMatrix, 0, 0, 0);
        int costBlue = paintHelper(costMatrix, 0, 1, 0);
        int costGreen = paintHelper(costMatrix, 0, 2, 0);

        return Math.min(costRed, Math.min(costBlue, costGreen));
    }

    private int paintHelper(int[][] costMatrix, int houseIndex, int currentColor, int accumulatedCost) {
        // base case
        if (houseIndex == costMatrix.length) {
            return accumulatedCost;
        }

        if (currentColor == 0) { // Red
            return Math.min(
                paintHelper(costMatrix, houseIndex + 1, 1, accumulatedCost + costMatrix[houseIndex][0]), // Blue
                paintHelper(costMatrix, houseIndex + 1, 2, accumulatedCost + costMatrix[houseIndex][0])  // Green
            );
        } else if (currentColor == 1) { // Blue
            return Math.min(
                paintHelper(costMatrix, houseIndex + 1, 0, accumulatedCost + costMatrix[houseIndex][1]), // Red
                paintHelper(costMatrix, houseIndex + 1, 2, accumulatedCost + costMatrix[houseIndex][1])  // Green
            );
        } else if (currentColor == 2) { // Green
            return Math.min(
                paintHelper(costMatrix, houseIndex + 1, 0, accumulatedCost + costMatrix[houseIndex][2]), // Red
                paintHelper(costMatrix, houseIndex + 1, 1, accumulatedCost + costMatrix[houseIndex][2])  // Blue
            );
        }

        return -1;
    }
}
