class Solution {
    public int minCost(int[][] costs) {

        // If the costs array is null return 0

        if(costs==null || costs.length==0)
        {
            return 0;
        }

// If we choose the first house to be red what will be the corresponding cost after tha
        int colorRed = recurse(costs, 0, 0, 0); 
        // If we choose the first house to be blue what will be the corresponding cost after tha
        int colorBlue = recurse(costs, 0, 1, 0);
        // If we choose the first house to be green what will be the corresponding cost after tha
        int colorGreen = recurse(costs, 0, 2, 0);
        return  Math.min(colorGreen, Math.min(colorRed, colorBlue));

    }

    private int recurse(int[][] costs, int row, int color, int totalCost)
    {
        if(row==costs.length)
        {
            return totalCost;
        }
      if(color == 0)
      {
        // If we start painting first house with red color
        return Math.min(recurse(costs, row+1, 1,totalCost+costs[row][color]),recurse(costs, row+1, 2,totalCost+costs[row][color]));
      }
      if(color == 1)
      {
          // If we start painting house with blue color
return Math.min(recurse(costs, row+1, 0,totalCost+costs[row][color]),recurse(costs, row+1, 2,totalCost+costs[row][color]));
      }
      if(color == 2)
      {
          // If we start painting house with green color 
return Math.min(recurse(costs, row+1, 0,totalCost+costs[row][color]),recurse(costs, row+1, 1,totalCost+costs[row][color]));
      }
      return 1234567;
    }

    

}
