class Solution {
    public int minCost(int[][] costs) {
        // When array is not mutable so created a new array dp

        // Time Complexity: O (n) where n is number of rows 
        // Space complexity: O (m) where m is number of columns which is O(3)
       // which is  constant

        // If the costs array is null return 0

        if(costs==null || costs.length==0)
        {
            return 0;
        }

        int n = costs.length; 
        int[] dp = new int[3];
       // int colorRed = 0, colorBlue = 0, colorGreen = 0;
       // If there is just onr house simply return the minimum value of painting
        if(n==1)
        {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }

        if(n>=2)
        {
            int row = n-2;
            // Intialize dp aaray with cost of painting last house with red color
            dp[0] = costs[row+1][0];
            // Intialize dp aaray with cost of painting last house with blue color
            dp[1] = costs[row+1][1];
            // Intialize dp aaray with cost of painting last house with green color
            dp[2] = costs[row+1][2];

            while(row>=0)
            {
             int colorRed =  costs[row][0] + Math.min (dp[1],dp[2]); 
             int colorBlue =  costs[row][1] + Math.min (dp[0],dp[2]); 
             int colorGreen =  costs[row][2] + Math.min (dp[0],dp[1]); 
             dp[0] = colorRed;
             dp[1] = colorBlue;
             dp[2] = colorGreen;
            row--;
            }
        }
        
      //return Math.min(colorRed,Math.min(colorBlue,colorGreen));
      //return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
      return Math.min(dp[0],Math.min(dp[1],dp[2]));

    

}
}
