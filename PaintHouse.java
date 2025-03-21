// Time Complexity : O(N),  (N -> number of houses(costs.length))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach:
// Line 1: Starting from the second house, update its cost by adding the 
//         minimum cost of painting it with a different color from the previous house.
// Line 2: Repeat this process for all three colors for each house.
// Line 3: Finally, return the minimum cost of painting the last house, ensuring no two adjacent houses have the same color.



public class PaintHouse {
    
    public static int minCost(int[][] costs) 
    {
        for(int i=1;i<costs.length;i++)
        {
            for(int j=0;j<costs[i].length;j++)
            {
                if(j==0)
                {
                    costs[i][0] =  costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]);
                }
                if(j==1)
                {
                    costs[i][1] =  costs[i][1] + Math.min(costs[i-1][0],costs[i-1][2]);
                }
                if(j==2)
                {
                    costs[i][2] =  costs[i][2] + Math.min(costs[i-1][0],costs[i-1][1]);
                }
            }
        }
        int x = Math.min(costs[costs.length-1][0],costs[costs.length-1][1]);
        int y = Math.min(costs[costs.length-1][2],x);
        return y;
    }
    public static void main(String[] args) 
    {
         int[][] costs = {
                            {17, 2, 17},
                            {16, 16, 5},
                            {14, 3, 19}
                         };
        int result = minCost(costs);
        System.out.println("Test Case 1: " + result);
    }
}