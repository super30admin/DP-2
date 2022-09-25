//Time Complexity: O(N)
//Space Complexity: O(1)
class Solution {
    public int minCost(int[][] costs) {

        if (costs.length == 0) return 0;

        int[] previousRow = costs[costs.length -1];

        for (int n = costs.length - 2; n >= 0; n--) {

            /* PROBLEMATIC CODE IS HERE
             * This line here is NOT making a copy of the original, it's simply
             * making a reference to it Therefore, any writes into currentRow
             * will also be written into "costs". This is not what we wanted!
             */
            int[] currentRow = costs[n];

            // Total cost of painting the nth house red.
            currentRow[0] += Math.min(previousRow[1], previousRow[2]);
            // Total cost of painting the nth house green.
            currentRow[1] += Math.min(previousRow[0], previousRow[2]);
            // Total cost of painting the nth house blue.
            currentRow[2] += Math.min(previousRow[0], previousRow[1]);
            previousRow = currentRow;
        }  

        return Math.min(Math.min(previousRow[0], previousRow[1]), previousRow[2]);
    }
}
