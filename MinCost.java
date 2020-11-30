/**There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. 
* The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
* Time complexity is O(MN). Space complexity is O(1)
* Painting each house depends on cost to paint the current house plus previous rows minimum cost to paint other colors house
*/
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length; //row
        int redCost = costs[0][0], blueCost = costs[0][1], greenCost = costs[0][2];
        for (int i = 1; i <n; i++) {
           int rMin = Math.min(blueCost, greenCost);
           int bMin = Math.min(redCost, greenCost);
           int gMin = Math.min(redCost, blueCost);
           redCost = costs[i][0] + rMin;
           blueCost = costs[i][1] + bMin;
           greenCost = costs[i][2] + gMin;
        }
        return Math.min(redCost, Math.min(blueCost, greenCost));
    }
}


