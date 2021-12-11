// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// DP approach no space
public class PaintHouse {

    public int minCost(int [][]costs)
    {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        for(int i = n-2 ; i >= 0; i--) // we start from last row
        {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]); // current house costs + next house min(blue, green)
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]); // current house costs + next house min(red, green)
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]); // current house costs + next house min(red, blue)
        }

        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2])); // min costs among all three color option trees
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) since colors is constant i.e 3
// DP approach extra space
public class PaintHouse {

    public int minCost(int [][]costs)
    {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int dp [][] = new int[n][3]; // since we can paint only using 2 colors
        
        for(int i = 0; i < 3 ; i++) // we want to fill the dp array with last cost row
        {
            dp[n-1][i] = costs[n-1][i];
        }

        for(int i = n-2 ; i >= 0; i--) // we start from last row
        {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]); // current house costs + next house min(blue, green)
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]); // current house costs + next house min(red, green)
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]); // current house costs + next house min(red, blue)
        }

        return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2])); // min costs among all three color option trees
    }
}

// recursive approach
public class PaintHouse {

    public int minCost(int [][]costs)
    {
        if(costs == null || costs.length == 0)
            return 0;
        
        // paint house first house with either of three colors
        // costs, houseNo, color, costSoFar
        int red = helper(costs, 0, 0, 0);
        int blue = helper(costs, 0, 1, 0);
        int green = helper(costs, 0, 2, 0);

        return Math.min(red, Math.min(blue, green)); // min of all three options
    }
    

    private int helper(int[][]costs, int houseNo, int color, int costSoFar)
    {
        // base case
        if(houseNo == costs.length)
            return costSoFar;

        // recursive case
        if(color == 0)
        {
            int option1 = helper(costs, houseNo+1, 1, costSoFar + costs[houseNo][0]);
            int option2 = helper(costs, houseNo+1, 2, costSoFar + costs[houseNo][0]);
            return Math.min(option1, option2); // next house min color costs(blue, green)
        }
        else if(color == 1)
        {
            int option1 = helper(costs, houseNo+1, 0, costSoFar + costs[houseNo][1]);
            int option2 = helper(costs, houseNo+1, 2, costSoFar + costs[houseNo][1]);
            return Math.min(option1, option2); // next house min color costs(red, green)
        }
        else if(color == 2){
            int option1 = helper(costs, houseNo+1, 0, costSoFar + costs[houseNo][2]);
            int option2 = helper(costs, houseNo+1, 1, costSoFar + costs[houseNo][2]);
            return Math.min(option1, option2); // next house min color costs(red, blue)
        }
        return Integer.MAX_VALUE; //This wil never happen as we will color either one 
    }
}
