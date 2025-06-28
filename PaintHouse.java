class Solution {
    public int minCost(int[][] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        
        int n = coins.length;
        int red = coins[n - 1][0];
        int blue = coins[n - 1][1];
        int green = coins[n - 1][2];

        for (int i = n - 2; i >= 0; --i) {
            int tempRed = red;
            int tempBlue = blue;
            int tempGreen = green;
            red = coins[i][0] + Math.min(tempBlue, tempGreen);
            blue = coins[i][1] + Math.min(tempRed, tempGreen);
            green = coins[i][2] + Math.min(tempRed, tempBlue);
        }

        return Math.min(red, Math.min(blue, green));
    }
}