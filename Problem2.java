//Time Complexity: O(n) where n is the number of houses
// Space Complexity: O(1) since we are using only a few variables to store costs
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Three line explanation of solution in plain english:
// 1. We use a bottom-up approach to calculate the minimum cost of painting each house
// 2. For each house, we calculate the cost of painting it with each color by considering the minimum cost of painting the previous house with the other two colors
// 3. Finally, we return the minimum cost of painting all houses by considering the last house's costs for each color.


public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int n=costs.length;
        //we start from bottom up, we can use three variables to store the initial costs of house from last row
        int red=costs[n-1][0];
        int blue=costs[n-1][1];
        int green=costs[n-1][2];
        //we iterate from second last row to the first row
        //for each house, we calculate the minimum cost to paint it by considering the costs of the previous house
        for(int i=n-2;i>=0;i--){
            //we store the previous costs in temporary variables to avoid overwriting them
            int tempRed=red;
            //we calculate the new costs for the current house by adding the cost of painting it with the minimum cost of painting the previous house
            //we calculate for red, blue and green separately
            red=costs[i][0]+Math.min(blue,green);
            int tempBlue=blue;

            blue=costs[i][1]+Math.min(tempRed,green);
            green=costs[i][2]+Math.min(tempRed,tempBlue);
        }
        //finally we return the minimum cost of painting all houses
        return Math.min(red,Math.min(blue,green));
    }
}