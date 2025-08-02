// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode? Yes
/* Approach:We need to paint all houses such that no two adjacent houses have the same color, and the total painting cost is minimized.
 We initialize the first house’s cost for red, blue, and green.
 For each subsequent house, we calculate the minimum cost of painting it red, blue, or green, ensuring that we don’t pick the same color as the previous house.
We do this by adding the current house's cost for each color to the minimum of the other two colors from the previous step.
Finally, we return the minimum of the total costs for painting the last house red, blue, or green. */

public class PaintHouse {
    public int paintHouse(int[][] costs){
        if(costs == null || costs.length == 0){
            return 0;
        }

        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];

        for(int i = 1; i < costs.length; i++){
            int tempRed = costs[i][0] + Math.min(blue, green);
            int tempBlue = costs[i][1] + Math.min(green, red);
            int tempGreen = costs[i][2] + Math.min(red, blue);

            red = tempRed;
            blue = tempBlue;
            green = tempGreen;
        }

        return Math.min(red, Math.min(blue, green));
    }

}
