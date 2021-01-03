/*

TC: O(mn) where m is row and n is col
SC: O(1)
Thought: Take min of each row and add the value based on condition that we cannot use adjacent house to paint.
 */
class PainHouse{

    public int minCost(int[][] costs) {

        if (costs.length ==0 || costs == null) return 0;

        for (int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }

        return Math.min(costs[costs.length-1][0],
                Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}