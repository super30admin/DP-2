
// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {
        for(int i=1; i<costs.length; i++){
            //If we take first element, choose the remaning 2 elements from the previous row and add them.
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        // return the least element in the last row
        return Math.min(Math.min(costs[costs.length-1][0],costs[costs.length-1][1]),costs[costs.length-1][2]);
    }
}
