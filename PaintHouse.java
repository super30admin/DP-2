import java.util.*;


// 1. Recursion Approach


// Time Complexity : O(2^n) - Each house can branch into two possible colors (excluding the previous one)
// Space Complexity : O(n) - Recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - We recursively try painting each house with each possible color
// - We ensure no two adjacent houses have the same color by branching to other colors
// - Base case: when house index reaches the length of costs, return accumulated cost
public class PaintHouse
{
    public int minCost(int[][] costs)
    {
           // Try starting with Red, Green, and Blue for the first house
           int costR=recursiveHelper(costs,0,0,0);
           int costG=recursiveHelper(costs,0,1,0);
           int costB=recursiveHelper(costs,0,2,0);
           // Return minimum of the three
           return Math.min(costR,Math.min(costB,costG));
    }

    private int recursiveHelper(int[][] costs,int house,int color,int totalCost)
    {
        // Base case: all houses processed
        if(house==costs.length)
        {
           return totalCost;
        }
       // If current color is Red
       if(color==0)
       {
        return Math.min(recursiveHelper(costs, house+1,1, totalCost+costs[house][0]),
        recursiveHelper(costs, house+1, 2, totalCost+costs[house][0]));
       }
       // If current color is Green
       else if(color==1)
       {
        return Math.min(recursiveHelper(costs, house+1,0, totalCost+costs[house][1]),
        recursiveHelper(costs, house+1, 2, totalCost+costs[house][1]));
       }
       // If current color is Blue
       else
       {
        return Math.min(recursiveHelper(costs, house+1,0, totalCost+costs[house][2]),
        recursiveHelper(costs, house+1, 1, totalCost+costs[house][2]));
       }
       // This will never be reached
       return -1;
    }
}



// 2. DP - 2D Array Approach

// Time Complexity : O(n)
// Space Complexity : O(n) - for 2D dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - We fill the dp table bottom-up
// - dp[i][c] = cost of painting house i with color c + min cost of painting next house with a different color
class PaintHouse2D
{
    public int minCost(int[][] costs)
    {
        int m=costs.length;
        int[][] dp=new int[m][3];
        // Base case: last house costs
        dp[m-1][0]=costs[m-1][0];
        dp[m-1][1]=costs[m-1][1];
        dp[m-1][2]=costs[m-1][2];
        // Fill dp table from second last house to first
        for(int i=m-2;i>=0;i--)
        {
            dp[i][0]=costs[i][0]+ Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=costs[i][1]+ Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=costs[i][2]+ Math.min(dp[i+1][0],dp[i+1][1]);
        }
        // Return minimum cost starting from house 0
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}



// 3. DP - 1D Array Approach


// Time Complexity : O(n)
// Space Complexity : O(1) - reusing a single array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - Same as 2D DP but we only keep track of the last row at a time
class PaintHouse1D
{
    public int minCost(int[][] costs)
    {
        int m=costs.length;
        int[] dp=new int[3];
        // Initialize with last house's costs
        dp[0]=costs[m-1][0];
        dp[1]=costs[m-1][1];
        dp[2]=costs[m-1][2];
        // Fill from bottom up
        for(int i=m-2;i>=0;i--)
        {
            int tempR=dp[0];
            int tempG=dp[1];
            dp[0]=costs[i][0]+Math.min(dp[1],dp[2]);
            dp[1]=costs[i][1]+Math.min(tempR,dp[2]);
            dp[2]=costs[i][2]+Math.min(tempG,tempR);
        }
        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }
}



// 4. More Optimized Variable Approach


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - Instead of an array, store values in separate variables for each color
class PaintHouseVar
{
    public int minCost(int[][] costs)
    {
        int m=costs.length;
        int costR=costs[m-1][0];
        int costG=costs[m-1][1];
        int costB=costs[m-1][2];
        for(int i=m-2;i>=0;i--)
        {
            int tempR=costR;
            int tempG=costG;
            costR=costs[i][0]+Math.min(costB,costG);
            costG=costs[i][1]+Math.min(tempR,costB);
            costB=costs[i][2]+Math.min(tempR,tempG);
        }
        return Math.min(costR,Math.min(costG,costB));
    }
}



// 5. Path Matrix Approach (Tracking path)


// Time Complexity : O(n)
// Space Complexity : O(n) - for dp and path arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - Along with DP table, we maintain a path array storing next color choice for each house
// - After filling dp, we can reconstruct the color sequence
class PaintHousePath
{
    public int minCost(int[][] costs)
    {
        int m=costs.length;
        int[][] dp=new int[m][3];
        int[][] path=new int[m][3];
        // Initialize with last house costs
        dp[m-1][0]=costs[m-1][0];
        dp[m-1][1]=costs[m-1][1];
        dp[m-1][2]=costs[m-1][2];
        // Fill bottom-up and record path decisions
        for(int i=m-2;i>=0;i--)
        {
            if(dp[i+1][1]<dp[i+1][2])
            {
                path[i][0]=1;
            }
            else
            {
                path[i][0]=2;
            }
            if(dp[i+1][0]<dp[i+1][2])
            {
                path[i][1]=0;
            }
            else
            {
                path[i][1]=2;
            }
            if(dp[i+1][0]<dp[i+1][1])
            {
                path[i][2]=0;
            }
            else
            {
                path[i][2]=1;
            }
            dp[i][0]=costs[i][0]+ Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=costs[i][1]+ Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=costs[i][2]+ Math.min(dp[i+1][0],dp[i+1][1]);
        }
        // Find starting color
        int min=0;
        if(dp[0][0]<dp[0][1]&&dp[0][0]<dp[0][2])
        {
            min=0;
        }
        else if(dp[0][1]<dp[0][0] && dp[0][1]<dp[0][2])
        {
            min=1;
        }
        else
        {
            min=2;
        }
        // Print chosen costs for each house
        int i=0;
        while(i<m)
        {
            System.out.println(costs[i][min]);
            min=path[i][min];
            i++;
        }
        // Debug print path matrix
        System.out.println(Arrays.deepToString(path));
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}
