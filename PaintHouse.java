package Oct24;

class PaintHouse {
    public int minCost(int[][] costs) {
        
    /* 
      Time Complexity: O(n) where n is no.of elements in the costs array. 
	  Because we are traversing the costs array once completely across all n rows and 3 columns.
      Since no.of columns is fixed as 3, so time complexity asymptotically is O(n).

	  Space Complexity: O(n)
	  Because we are not using any extra space other than the given costs array. 
	        
	  Did this code successfully run on Leetcode : Yes

	  Any problem you faced while coding this : No

      Approach:
        
        costs array       |     modified costs array
        __________________|__________________________________________________________________
                          |  
        17  2  17         |     17                  2                   17
        16  16  5         |     min(2,17)+16=18     min(17,17)+16=33    min(17,2)+5=7
        14  3   19        |     min(33,7)+14=21     min(19,7)+3=10      min(18,33)+19=37
    
        */
        
        // edge cases
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
        
    }
}