// Time Complexity : O(n) ,where n is the no. of houses
// Space Complexity : O(1) beacuse we are makinhg changes in costs array only ; so no auxiliary space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE
public class paintHouse {
    public int minCost(int[][] costs) {
        // null case
        if (costs == null || costs.length == 0)
            return 0;

        for (int i = costs.length - 2; i >= 0; i--) { // mutating by bottom top approach
            // red
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]); // for column 0 ; we have to add min
                                                                                    // of column 1 and 2 from next row
                                                                                    // to current index for red(0)
            // blue
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]); // for column 1 ; we have to add min
                                                                                    // of column 0 and 2 from next row
                                                                                    // to current index for blue(1)
            // green
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]); // for column 2 ;we have to add min
                                                                                    // of column 0 and 1 from next
                                                                                    // row(i+1) to current index for
                                                                                    // green(2)

            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2])); // returning min of first row

        }
    }

}

// brute force ->time = 3*2^n
public class paintHouse {
    public int minCost(int[][] costs) {
        // null case
        if (costs == null || costs.length == 0)
            return 0;

        int caseR = helper(costs, 0, 0, 0);
        int caseB = helper(costs, 0, 1, 0);
        int caseG = helper(costs, 0, 2, 0);

        return Math.min(caseR, caseB, caseG);
    }

    private int helper(int[][] costs, int index, int color, int min) {
        // base
        if (index == costs.length)
            return min;

        // logic
        if (color == 0) {
            return Math.min(helper(costs, index + 1, 1, min + costs[index][0]),
                    helper(costs, index + 1, 2, min + costs[index][0]));
        } else if (color == 1) {
            return Math.min(helper(costs, index + 1, 0, min + costs[index][1]),
                    helper(costs, index + 1, 2, min + costs[index][1]));
        } else {
            return Math.min(helper(costs, index + 1, 0, min + costs[index][2]),
                    helper(costs, index + 1, 2, min + costs[index][2]));
        }

    }
}
