// Did this code successfully run on Leetcode : Don't have premium account
// Any problem you faced while coding this : No
// Approach :

// Since we cant have two houses of the same color, we need to track the current color chosen and pass it to the recursive calls. For example, if blue is chosen, we will
// try to find minimum if we chose red or green for the next house. And then add it to the blue paint cost. At any node,in the above manner, we will calculate what is cost
// of painting the house with the three colors and find their minimum value.
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintHouse {

     static void main(String[] args) {
      //  int[][] costs = {{17,2,17}, {16, 16, 5}, {14,3,9}};
        int[][] costs = {{7, 7, 7}, {6, 6, 6}, {4, 4, 9}};

        int withRedPaint = minPaintCost(costs, 0, 0);
        int withBluePaint = minPaintCost(costs, 0, 1);
        int withGreenPaint = minPaintCost(costs, 0, 2);

        int minPaintCost = Math.min(withRedPaint, Math.min(withGreenPaint, withBluePaint));
        System.out.println("Paint cost with Recursion: "+ minPaintCost);

        int withRedPaintMemo = minPaintCostMemo(costs, 0, 0, new HashMap<>());
        int withBluePaintMemo = minPaintCostMemo(costs, 0, 1, new HashMap<>());
        int withGreenPaintMemo = minPaintCostMemo(costs, 0, 2, new HashMap<>());
        int minPaintCostMemo = Math.min(withRedPaintMemo, Math.min(withBluePaintMemo, withGreenPaintMemo));
        System.out.println("Paint cost with Memo: "+ minPaintCostMemo);

        int minTabulation = minPaintCostTabulation(costs);
        System.out.println("Paint cost with Tabulation: "+minTabulation);

        int minSpace = minPaintCostSpaceOptimization(costs);
        System.out.println("Paint cost with Tabulation and space optimization: " + minSpace);
    }

    public static int minPaintCostSpaceOptimization(int[][] costs) {
        // Time Complexity : O(N), where N is number of houses
        // Space Complexity : O(1), use 3 variables to keep track of what is current min if we choose color Red, Green or Blue
        int minRed = 0, minBlue = 0, minGreen = 0;

        for (int[] cost : costs) {
            int prevRed = minRed;
            int prevBlue = minBlue;
            int prevGreen = minGreen;

            // Calculate value at each house if the current color is chosen, then add it with the minimum cost of painting the previous house with other 2 colors
            // as we cant have two adjacent houses painted with same color
            minRed = cost[0] + Math.min(prevBlue, prevGreen);
            minBlue = cost[1] + Math.min(prevRed, prevGreen);
            minGreen = cost[2] + Math.min(prevRed, prevBlue);
        }

        return Math.min(minRed, Math.min(minBlue, minGreen));
    }

    public static int minPaintCostTabulation(int[][] costs) {
        // Time Complexity : O(NC), where N is number of houses, C is number of colors
        // Space Complexity : O(NC), store value at each house by adding the current chosen color with minimum of other two colors for the previous house
        int houses = costs.length+1;
        int colors = costs[0].length;
        int[][] minCost = new int[houses][colors];
        // The first row is all 0s, so that house 1 can use this result

        for(int i = 1; i < houses; i++){
            for (int j = 0; j < colors; j++) {
                if(j == 0) {
                    // current color cost +  min of colors for prev house
                    minCost[i][j] = costs[i-1][0] + Math.min(minCost[i-1][1], minCost[i-1][2]);
                }else if(j == 1){
                    minCost[i][j] = costs[i-1][1] + Math.min(minCost[i-1][0], minCost[i-1][2]);
                }else {
                    minCost[i][j] = costs[i-1][2] + Math.min(minCost[i-1][0], minCost[i-1][1]);
                }
            }
        }
        // The last row has all the costs for different colors added up, so find the min of the three.
        return Math.min(minCost[houses-1][0], Math.min(minCost[houses-1][1], minCost[houses-1][2]));
    }

    public static int minPaintCostMemo(int[][] costs, int houseIdx, int currentColor, Map<List<Integer>, Integer> memo) {
        // Time Complexity : O(NC), where N is number of houses, C is number of colors
        // Space Complexity : O(N), the recursion stack will be deep till it evaluates all houses.

        if (houseIdx >= costs.length) return 0;

        // Keep the changing house index and color in the memo
        List<Integer> key = List.of(houseIdx, currentColor);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int currentCost = costs[houseIdx][currentColor];
        if (currentColor == 0) {
            currentCost += Math.min(minPaintCostMemo(costs, houseIdx + 1, 1, memo), minPaintCostMemo(costs, houseIdx + 1, 2, memo));
        }


        if (currentColor == 1) {
            currentCost += Math.min(minPaintCostMemo(costs, houseIdx + 1, 0, memo), minPaintCostMemo(costs, houseIdx + 1, 2, memo));
        }

        if (currentColor == 2) {
            currentCost += Math.min(minPaintCostMemo(costs, houseIdx + 1, 0, memo), minPaintCostMemo(costs, houseIdx + 1, 1, memo));
        }

        memo.put(key, currentCost);
        return currentCost;
    }

    public static int minPaintCost(int[][] costs, int houseIdx, int currentColor) {
        // Time Complexity : O(3(2^N)). The recursion levels will have 3, 6, 12 calls, till N houses are evaluated
        // Space Complexity : O(N), the recursion stack will be deep till it evaluates all N houses.
        if (houseIdx >= costs.length) return 0;

        int currentCost = costs[houseIdx][currentColor];

        // If we take any current color. Also find the min cost if we chose any of other 2 color for the next house recursively.
        if (currentColor == 0) {
            currentCost += Math.min(minPaintCost(costs, houseIdx + 1, 1), minPaintCost(costs, houseIdx + 1, 2));
        }

        if (currentColor == 1) {
            currentCost += Math.min(minPaintCost(costs, houseIdx + 1, 0), minPaintCost(costs, houseIdx + 1, 2));
        }

        if (currentColor == 2) {
            currentCost += Math.min(minPaintCost(costs, houseIdx + 1, 0), minPaintCost(costs, houseIdx + 1, 1));
        }

        return currentCost;
    }
}
