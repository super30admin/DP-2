// we start with the second row(2nd house) and to paint a particular house, with that color, we select the minimum costs needed
// to paint the previous house with the color other than the current color. 
// We continue this until the last hose and return the minimum cost.

// Time Complexity : O(n), where n is the number of houses
// Space Complexity : O(1)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaintHouse {

    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length;

        int[] previousRow = costs[0];
        for (int i = 1; i < n; i++) {
            int[] currentRow = new int[3];
            for (int j = 0; j < 3; j++) {
                currentRow[j] = costs[i][j] + Math.min(previousRow[(j + 1) % 3], previousRow[(j + 2) % 3]);
            }
            previousRow = currentRow;
        }
        return Math.min(previousRow[0], Math.min(previousRow[1], previousRow[2]));
    }

    public static void main(String[] args) {
        List<int[][]> input = new ArrayList<>();
        Collections.addAll(input, new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } });

        for (int[][] costs : input) {
            System.out.println(minCost(costs));
        }
    }
}