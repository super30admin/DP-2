class Solution {
    public int minCost(int[][] costs) {
        // When array is not mutable so created a new array dp

        // Time Complexity: O (n) where n is number of rows 

        // If the costs array is null return 0

        if(costs==null || costs.length==0)
        {
            return 0;
        }

        int n = costs.length; 
       // If there is just one house simply return the minimum value of painting
        if(n==1)
        {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }

         int colorRed = 0, colorBlue =0,colorGreen =0 ;

        if(n>=2)
        {
            int row = n-2;
             colorRed = costs[row+1][0];
             colorBlue = costs[row+1][1];
             colorGreen = costs[row+1][2];

            while(row>=0)
            {
              int tempRed = colorRed;
              colorRed =  costs[row][0] + Math.min (colorBlue,colorGreen); 
              int tempBlue = colorBlue;
              colorBlue =  costs[row][1] + Math.min (tempRed, colorGreen); 
              colorGreen =  costs[row][2] + Math.min (tempRed,tempBlue);
            row--;
            }
        }
        
      return Math.min(colorRed,Math.min(colorBlue,colorGreen));
      //return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
      //return Math.min(dp[0],Math.min(dp[1],dp[2]));

    

}
}
