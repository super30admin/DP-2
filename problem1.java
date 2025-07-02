// Time Complexity: O(n) where n is number of houses
// Space Complexity: O(1) constant space needed

// Using 3 variables red blue and green to store what happens if we paint the first house, and memoizing by adding new paint cost to these variables 


class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int dp[][] = new int[costs.length][3];
        
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];

        // the above 3 denotes that we start painting the first house with red, or blue, or green and obtain the lowest cost for these 3 paths

        for (int i = 1; i < costs.length; i++) {
            // loop over each house

            int tempRed = red, tempBlue = blue, tempGreen = green;
            
            red = costs[i][0] + Math.min(tempBlue, tempGreen);

            blue = costs[i][1] + Math.min(tempRed, tempGreen);

            green = costs[i][2] + Math.min(tempRed, tempBlue);
        }

        return Math.min(red, Math.min(blue, green));
    }
}
