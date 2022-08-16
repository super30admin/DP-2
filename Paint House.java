// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {

        if (costs.length == 0)
            return 0;

        int[] previousRow = costs[costs.length - 1];

        for (int n = costs.length - 2; n >= 0; n--) {

            int[] currentRow = costs[n];

            currentRow[0] += Math.min(previousRow[1], previousRow[2]);

            currentRow[1] += Math.min(previousRow[0], previousRow[2]);

            currentRow[2] += Math.min(previousRow[0], previousRow[1]);
            previousRow = currentRow;
        }

        return Math.min(Math.min(previousRow[0], previousRow[1]), previousRow[2]);
    }
}