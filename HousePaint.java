// Time Complexity : O(mn) where mis theu number of houses and n is the number of colors
// Space Complexity : O(1) since we are doing the opeartions in place (each new row is only dependent on the previous row)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially, I was not able to model the problem into 2d array. I wasnt able to check previous color
/* Your code here along with comments explaining your approach: The first row remains as it is as House 1 has all the 3 possibilities that 
it can either begin with color R,B or G. In House 2, I assume that it was not previously colored with the same corresponding color and hence, my cost 
becomes minimum of the costs of the remaining two colors. I follow the previous step for each of the houses and colors and add the current
color cost to the cost occurred till now. At the end, I display the minimum cost in total in the last row. 
*/
class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null){return 0;}
        for(int i = 1;  i< costs.length;i++){
                costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);     // Condition for each color to sum up with the remaining colors 
                costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
                costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
    }
    return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));  // min from the last row
    }
}